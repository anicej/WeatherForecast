package com.anice.weatherforcast.data.mapper

import com.anice.weatherforcast.data.mapper.base.BaseMapper
import com.anice.weatherforcast.data.model.DailyTempModel
import com.anice.weatherforcast.domain.entity.TodoEntity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoEntityToModelMapper @Inject constructor() : BaseMapper<TodoEntity, DailyTempModel>() {



    override fun map(entity: TodoEntity?): DailyTempModel? {
//        TODO("Not yet implemented")
    return null
    }
}