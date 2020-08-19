package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastCityCoord : Serializable {
    var lon = 0.0
    var lat = 0.0

    companion object {
        private const val serialVersionUID = 7859086659979529672L
    }
}