package com.example.castshow.cast_show_feature.domain.use_case

import com.example.castshow.core.domain.SelectAndSortableByName

class FilterListByNameUseCase {
    operator fun <T> invoke(
        list: List<T>, name: String
    ): List<T> where T : SelectAndSortableByName {
        return list.filter { item ->
            item.name.lowercase().contains(name.lowercase())

        }
    }
}