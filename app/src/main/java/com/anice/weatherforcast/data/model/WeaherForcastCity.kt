package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastCity : Serializable {
    var country: String? = null
    var coord: WeaherForcastCityCoord? = null
    var sunrise = 0
    var timezone = 0
    var sunset = 0
    var name: String? = null
    var id = 0
    var population = 0

    companion object {
        private const val serialVersionUID = 5408053274893439297L
    }
}