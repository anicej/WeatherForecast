package com.anice.weatherforcast.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.anice.weatherforcast.R
import com.anice.weatherforcast.data.model.DailyTempModel
import com.anice.weatherforcast.databinding.RvDaytempItemsBinding

class DailyWeatherAdapter(private val list: List<DailyTempModel>,private val context:Context):RecyclerView.Adapter<DailyWeatherAdapter.DailyWeatherViewHolder>() {


    @NonNull
    override fun onCreateViewHolder(@NonNull parent:ViewGroup, viewType:Int):DailyWeatherViewHolder {
        val binding = DataBindingUtil.inflate<RvDaytempItemsBinding>(LayoutInflater.from(parent.getContext()), R.layout.rv_daytemp_items, parent, false)
        return DailyWeatherViewHolder(binding)
    }
    override fun onBindViewHolder(@NonNull holder:DailyWeatherViewHolder, position:Int) {
        val weather = list.get(position)
        holder.binding.item=weather

    }
    inner class DailyWeatherViewHolder(@NonNull binding:RvDaytempItemsBinding):RecyclerView.ViewHolder(binding.getRoot()) {
        val binding:RvDaytempItemsBinding
        init{
            this.binding = binding
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }


}