package com.anice.weatherforcast.data.model

import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat

import androidx.databinding.BindingAdapter




data class DailyTempModel(
    var image: Int,
    var maxTemp: String,
    var minTemp: String,
    var weekDay: String){

    //code for loading image
    @BindingAdapter("android:imageUrl")
    fun loadImage(view: View, imageId: Int) {
        val imageView: ImageView = view as ImageView
        imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), imageId))
    }

    operator fun invoke(dailyTempModel: DailyTempModel) {


    }

}