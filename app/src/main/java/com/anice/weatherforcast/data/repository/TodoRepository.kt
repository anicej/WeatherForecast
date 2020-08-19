package com.anice.weatherforcast.data.repository

import com.anice.weatherforcast.data.model.WeaherForcast
import com.anice.weatherforcast.domain.remote.response.ApiResponse
import com.anice.weatherforcast.domain.repository.BaseTodoRepository
import com.anice.weatherforcast.domain.service.TodoService
import com.anice.weatherforcast.util.AppConstant
import javax.inject.Inject

class TodoRepository @Inject constructor(private val service: TodoService) : BaseTodoRepository(service) {

    override suspend fun getTodoList(todoId:String ): ApiResponse<WeaherForcast> {
        return handleRequest { service.getTotoDetails(todoId,AppConstant.API_KEY,"28") }
    }
}