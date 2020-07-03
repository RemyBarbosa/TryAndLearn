package com.tryandlearn.weather.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.tryandlearn.interface_adapter.base.ErrorState
import com.tryandlearn.interface_adapter.base.LoadingState
import com.tryandlearn.interface_adapter.weather.HourlyWeatherViewModel
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import com.tryandlearn.R
import com.tryandlearn.weather.ui.detail.WeatherDetailFragmentArgs
import com.tryandlearn.util.hide
import com.tryandlearn.util.show
import com.tryandlearn.weather.ui.adapter.WeatherListAdapter
import kotlinx.android.synthetic.main.fragment_weather_detail.*
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherDetailFragment : Fragment() {

    val args: WeatherDetailFragmentArgs by navArgs()

    private val viewModel by viewModel<HourlyWeatherViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
        viewModel.observeHourlyWeatherList(args.latitude, args.longitude, args.count, args.units, args.appId)
    }

    private fun observeViewModel() {
        viewModel.states.observe(viewLifecycleOwner, Observer { state ->
            state?.let {
                when (state) {
                    is LoadingState -> showLoader()
                    is ErrorState -> showError(state.error)
                    is HourlyWeatherViewModel.HourlyWeatherListState -> showHourlyWeatherList(state.weatherUIModelList)
                }
            }
        })
    }

    private fun showHourlyWeatherList(weatherUIModelList: List<WeatherUIModel>) {
        if (hourly_weather_list.adapter == null) {
            hourly_weather_list.adapter = WeatherListAdapter()

        }
        (hourly_weather_list.adapter as WeatherListAdapter).weatherList = weatherUIModelList.toMutableList()
        progress_bar.hide()

    }

    private fun showError(error: Throwable) {
        progress_bar.hide()
        hourly_weather_error.show()
        hourly_weather_error.text = error.toString()
    }

    private fun showLoader() {
        progress_bar.show()
    }
}
