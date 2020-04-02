package com.rocketskill.weather.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.rocketskill.interface_adapter.base.ErrorState
import com.rocketskill.interface_adapter.base.LoadingState
import com.rocketskill.interface_adapter.weather.DailyWeatherViewModel
import com.rocketskill.interface_adapter.weather.model.WeatherUIModel
import com.rocketskill.R
import com.rocketskill.weather.ui.list.WeatherListFragmentDirections
import com.rocketskill.util.hide
import com.rocketskill.util.show
import com.rocketskill.weather.ui.adapter.WeatherListAdapter
import kotlinx.android.synthetic.main.fragment_weather_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class WeatherListFragment : Fragment() {

    companion object {
        private const val LATITUDE = 48.853f
        private const val LONGITUDE = 2.3488f
        private const val COUNT = 10
        private const val UNITS = "metric"
        private const val APP_ID = "e373fbdfb7c805a59762e6388e9ede6b"
    }

    private val viewModel by viewModel<DailyWeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hourly_weather_button.setOnClickListener {
            val action = WeatherListFragmentDirections.actionWeatherListFragmentToWeatherDetailFragment2(
                LATITUDE,
                LONGITUDE,
                COUNT,
                UNITS,
                APP_ID
            )
            findNavController().navigate(action)
        }

        observeViewModel()
        viewModel.observeDailyWeatherList(
            LATITUDE,
            LONGITUDE,
            COUNT,
            UNITS,
            APP_ID
        )
    }


    private fun observeViewModel() {
        viewModel.states.observe(viewLifecycleOwner, Observer { state ->
            state?.let {
                when (state) {
                    is LoadingState -> showLoader()
                    is ErrorState -> showError(state.error)
                    is DailyWeatherViewModel.DailyWeatherListState -> showDailyWeatherList(state.weatherUIModelList)
                }
            }
        })
    }

    private fun showDailyWeatherList(weatherUIModelList: List<WeatherUIModel>) {
        if (hourly_weather_list.adapter == null) {
            hourly_weather_list.adapter = WeatherListAdapter()

        }
        (hourly_weather_list.adapter as WeatherListAdapter).weatherList = weatherUIModelList.toMutableList()
        progress_bar.hide()

    }

    private fun showError(error: Throwable) {
        progress_bar.hide()
        daily_weather_error.show()
        daily_weather_error.text = error.toString()
    }

    private fun showLoader() {
        progress_bar.show()
    }
}
