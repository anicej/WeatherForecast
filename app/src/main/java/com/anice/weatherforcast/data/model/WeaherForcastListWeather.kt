package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastListWeather : Serializable {
    var icon: String? = null
    var description: String? = null
    var main: String? = null
    var id = 0

    companion object {
        private const val serialVersionUID = -1740358412354033565L
    }
}