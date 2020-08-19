package com.anice.weatherforcast.data.model

import java.io.Serializable

class WeaherForcastList : Serializable {
    var dt = 0
    var dt_txt: String? = null
    lateinit var weather: Array<WeaherForcastListWeather>
    var main: WeaherForcastListMain? = null
    var clouds: WeaherForcastListClouds? = null
    var sys: WeaherForcastListSys? = null
    var wind: WeaherForcastListWind? = null

    companion object {
        private const val serialVersionUID = -6503889870573347866L
    }
}