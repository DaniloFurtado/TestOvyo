package com.example.testovyo.presentation.di

import com.example.testovyo.data.di.dataModule
import com.example.testovyo.presentation.viewmodel.MyViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel { MyViewModel(get()) }
    factory { Dispatchers.IO }
}

val appModule = listOf(
    dataModule,
    presentationModule
)