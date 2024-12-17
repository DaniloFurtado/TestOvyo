package com.example.testovyo.domain.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}