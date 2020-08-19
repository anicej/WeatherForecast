package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastListWind : Serializable {
    var deg = 0
    var speed = 0.0

    companion object {
        private const val serialVersionUID = 5146595164519382542L
    }
}