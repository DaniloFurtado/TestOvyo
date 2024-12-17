package com.example.testovyo.domain.repository

import com.example.testovyo.domain.model.Item

interface MyRepository {
    suspend fun getMyData(): List<Item>
}