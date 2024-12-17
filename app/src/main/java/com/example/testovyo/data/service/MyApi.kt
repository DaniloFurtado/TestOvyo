package com.example.testovyo.data.service

import com.example.testovyo.data.dto.ItemDto
import retrofit2.http.GET

interface MyApi {

    @GET("")
    suspend fun getMyData(): List<ItemDto>
}