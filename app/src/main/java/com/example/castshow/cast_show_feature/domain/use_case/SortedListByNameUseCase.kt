package com.example.castshow.cast_show_feature.domain.use_case

import com.example.castshow.core.domain.SelectAndSortableByName

class SortedListByNameUseCase {
    operator fun <T> invoke(list: List<T>): List<T> where T : SelectAndSortableByName {
        return list.sortedBy { item ->
            item.name
        }
    }
}