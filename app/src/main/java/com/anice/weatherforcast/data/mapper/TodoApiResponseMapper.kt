package com.anice.weatherforcast.data.mapper

import com.anice.weatherforcast.data.mapper.base.BaseMapper
import com.anice.weatherforcast.data.model.DailyTempModel
import com.anice.weatherforcast.domain.entity.TodoEntity
import com.anice.weatherforcast.domain.remote.response.ApiResponse
import com.anice.weatherforcast.domain.remote.response.ErrorResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoApiResponseMapper @Inject constructor(private val mapper : TodoEntityToModelMapper)
    : BaseMapper<ApiResponse<TodoEntity>, ApiResponse<DailyTempModel>>() {

    override fun map(entity: ApiResponse<TodoEntity>?): ApiResponse<DailyTempModel>? {
        entity?.let {
            if(it.isSuccessful)
                return ApiResponse.Success(mapper.map(it.data))
            else
                return ApiResponse.Failure(it.errorResponse)
        }
        return ApiResponse.Failure(ErrorResponse())
    }
}