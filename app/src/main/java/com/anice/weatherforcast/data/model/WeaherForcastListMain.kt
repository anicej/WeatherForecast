package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastListMain : Serializable {
    var temp = 0.0
    var temp_min = 0.0
    var grnd_level = 0
    var temp_kf = 0.0
    var humidity = 0
    var pressure = 0
    var sea_level = 0
    var feels_like = 0.0
    var temp_max = 0.0

    companion object {
        private const val serialVersionUID = 6496374899052317300L
    }
}