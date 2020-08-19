package com.anice.weatherforcast.application

import android.app.Activity
import android.app.Application
import android.content.Context
import com.anice.weatherforcast.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class WeatherForeCastApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    init {
        instance = this
    }

    companion object {
        private var instance: WeatherForeCastApplication? = null
        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

        override fun activityInjector() = dispatchingAndroidInjector
}