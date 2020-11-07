package com.tryandlearn.interface_adapter.weather

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.tryandlearn.interface_adapter.base.ErrorState
import com.tryandlearn.interface_adapter.base.LoadingState
import com.tryandlearn.interface_adapter.base.RxViewModel
import com.tryandlearn.interface_adapter.base.State
import com.tryandlearn.interface_adapter.weather.model.WeatherUIModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class DailyWeatherViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle,
    private val weatherManager: WeatherManager
) : RxViewModel(), LifecycleObserver {

    private val mStates = MutableLiveData<State>()
    val states: LiveData<State>
        get() = mStates

    fun observeDailyWeatherList(
        latitude: Float,
        longitude: Float,
        count: Int,
        units: String,
        appId: String
    ) {
        mStates.value = LoadingState
        launch {
            weatherManager.getDailyWeatherList(latitude, longitude, count, units, appId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.computation())
                .subscribe(this::onDailyWeatherListReceive, this::onError)
        }
    }

    private fun onDailyWeatherListReceive(weatherUiModelList: List<WeatherUIModel>) {
        mStates.value = DailyWeatherListState(weatherUiModelList)
    }

    private fun onError(error: Throwable) {
        mStates.value = ErrorState(error)
    }

    data class DailyWeatherListState(val weatherUIModelList: List<WeatherUIModel>) : State()
}