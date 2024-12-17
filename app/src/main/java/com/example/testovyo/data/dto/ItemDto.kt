package com.example.testovyo.data.dto

import com.google.gson.annotations.SerializedName

data class ItemDto(
    @SerializedName("title")
    val title: String,
    @SerializedName("urlImage")
    val urlImage: String,
)