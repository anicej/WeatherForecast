package com.anice.weatherforcast.data.usecase

import com.anice.weatherforcast.data.mapper.TodoApiResponseMapper
import com.anice.weatherforcast.data.model.WeaherForcast
import com.anice.weatherforcast.data.repository.TodoRepository
import com.anice.weatherforcast.domain.remote.response.ApiResponse
import com.anice.weatherforcast.domain.usecase.base.BaseUseCase
import javax.inject.Inject

class TodoUseCase @Inject constructor(private val repository: TodoRepository,
                                      private val mapper : TodoApiResponseMapper
) : BaseUseCase(repository) {

    suspend fun getTodoList(todoId: String): ApiResponse<WeaherForcast> {
        val response = repository.getTodoList(todoId)
        return  response
//        mapper.map(response)!!
    }
}