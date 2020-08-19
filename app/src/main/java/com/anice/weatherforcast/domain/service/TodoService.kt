package com.anice.weatherforcast.domain.service

import com.anice.weatherforcast.data.model.WeaherForcast
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TodoService {

    @GET("forecast")
    suspend fun getTotoDetails(@Query("q") todoId : String, @Query("appid") todoI : String,@Query("cnt") todo : String) : Response<WeaherForcast>

}