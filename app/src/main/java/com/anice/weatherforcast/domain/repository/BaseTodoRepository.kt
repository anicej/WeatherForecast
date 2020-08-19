package com.anice.weatherforcast.domain.repository

import com.anice.weatherforcast.data.model.WeaherForcast
import com.anice.weatherforcast.domain.entity.TodoEntity
import com.anice.weatherforcast.domain.remote.response.ApiResponse
import com.anice.weatherforcast.domain.repository.base.IRepository
import com.anice.weatherforcast.domain.service.TodoService

abstract class BaseTodoRepository(service: TodoService) : IRepository {

    abstract suspend fun getTodoList(todoId : String) : ApiResponse<WeaherForcast>

}