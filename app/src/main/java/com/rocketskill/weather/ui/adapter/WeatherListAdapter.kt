package com.rocketskill.weather.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rocketskill.interface_adapter.weather.model.WeatherUIModel
import com.rocketskill.R
import com.rocketskill.util.inflateFromParent
import com.rocketskill.util.loadImage
import com.rocketskill.util.setTextOrInvisible
import kotlinx.android.synthetic.main.daily_weather_item.view.*

class WeatherListAdapter : RecyclerView.Adapter<WeatherListAdapter.DailyWeatherListViewHolder>() {

    var weatherList: MutableList<WeatherUIModel> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherListViewHolder {
        return DailyWeatherListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: DailyWeatherListViewHolder, position: Int) {
        val dailyWeatherView = weatherList[position]
        holder.bind(dailyWeatherView)
    }

    override fun getItemCount(): Int = weatherList.size

    class DailyWeatherListViewHolder(
        itemView: ViewGroup
    ) : RecyclerView.ViewHolder(itemView.inflateFromParent(R.layout.daily_weather_item)) {
        fun bind(weatherUIModel: WeatherUIModel) = with(itemView) {
            daily_background.loadImage(weatherUIModel.imageUrl)
            daily_date.text = weatherUIModel.date
            daily_descrption.setTextOrInvisible(weatherUIModel.description)
        }
    }
}
