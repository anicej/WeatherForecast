package com.anice.weatherforcast.domain.entity

data class TodoEntity(
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)