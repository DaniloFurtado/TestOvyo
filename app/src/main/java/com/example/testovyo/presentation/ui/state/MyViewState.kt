package com.example.testovyo.presentation.ui.state

import com.example.testovyo.domain.model.Item

data class MyViewState(
    var isLoading: Boolean = false,
    var items: List<Item> = emptyList()
)