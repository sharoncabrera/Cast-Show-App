package com.example.castshow.cast_show_feature.domain.use_case.model

import com.example.castshow.core.domain.SelectAndSortableByName

data class Character(
    val id: Int,
    override val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: String,
    val location: String,
    val image: String,
): SelectAndSortableByName

