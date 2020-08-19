package com.anice.weatherforcast.di.module

import com.anice.weatherforcast.data.mapper.TodoApiResponseMapper
import com.anice.weatherforcast.data.repository.TodoRepository
import com.anice.weatherforcast.data.usecase.TodoUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideTodoUseCase(repository: TodoRepository, mapper: TodoApiResponseMapper): TodoUseCase {
        return TodoUseCase(repository, mapper)
    }
}