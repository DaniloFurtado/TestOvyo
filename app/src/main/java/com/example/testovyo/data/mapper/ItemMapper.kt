package com.example.testovyo.data.mapper

import com.example.testovyo.data.dto.ItemDto
import com.example.testovyo.domain.mapper.Mapper
import com.example.testovyo.domain.model.Item

class ItemMapper : Mapper<ItemDto, Item> {
    override fun map(input: ItemDto): Item {
        return Item(
            title = input.title,
            urlImage = input.urlImage
        )
    }
}