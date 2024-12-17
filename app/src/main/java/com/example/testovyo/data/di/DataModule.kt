package com.example.testovyo.data.di

import com.example.testovyo.data.mapper.ItemMapper
import com.example.testovyo.data.repository.MyRepositoryImpl
import com.example.testovyo.data.service.MyApi
import com.example.testovyo.domain.repository.MyRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://google.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory {
        get<Retrofit>()
            .create(MyApi::class.java)
    }

    factory<MyRepository> {
        MyRepositoryImpl(
            api = get(),
            mapper = ItemMapper(),
            get()
        )
    }
}