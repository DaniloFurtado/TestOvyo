package com.example.testovyo.data.repository

import com.example.testovyo.data.dto.ItemDto
import com.example.testovyo.data.service.MyApi
import com.example.testovyo.domain.mapper.Mapper
import com.example.testovyo.domain.model.Item
import com.example.testovyo.domain.repository.MyRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class MyRepositoryImpl(
    private val api: MyApi,
    private val mapper: Mapper<ItemDto, Item>,
    private val dispatcher: kotlinx.coroutines.CoroutineDispatcher
) : MyRepository {
    override suspend fun getMyData() =
    // api.getMyData().let { dto ->
        /*dto.map { itemDto ->
            mapper.map(itemDto)
        }*/
        withContext(dispatcher) {
            delay(300)
            listOf(
                Item("This is Image 1", "https://placebear.com/150/150"),
                Item("This is Image 1", "https://picsum.photos/150/150"),
                Item("This is Image 1", "https://picsum.photos/150/150"),
                Item("This is Image 1", "https://placebear.com/150/150"),
            )
        }
    // }
}
