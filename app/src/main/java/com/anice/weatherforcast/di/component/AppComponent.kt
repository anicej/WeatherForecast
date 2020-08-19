package com.anice.weatherforcast.di.component

import android.app.Application
import com.anice.weatherforcast.application.WeatherForeCastApplication
import com.anice.weatherforcast.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityBuilderModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        ServiceModule::class,
        UseCaseModule::class]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: WeatherForeCastApplication)
}