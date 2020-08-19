package com.anice.weatherforcast.di.module

import com.anice.weatherforcast.view.activity.todo.TodoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Define all your activities here
 */

@Module(includes = [FragmentBuilderModule::class])
interface ActivityBuilderModule {

    @ContributesAndroidInjector
    fun contributeTodoActivity(): TodoActivity
}