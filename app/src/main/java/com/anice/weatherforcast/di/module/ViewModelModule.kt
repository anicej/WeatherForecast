package com.anice.weatherforcast.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.anice.weatherforcast.di.key.ViewModelKey
import com.anice.weatherforcast.view.activity.todo.TodoViewModel
import com.anice.weatherforcast.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    fun bindTodoViewModel(todoViewModel: TodoViewModel): ViewModel
}