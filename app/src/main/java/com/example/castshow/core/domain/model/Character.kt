package com.example.castshow.core.domain.model

import com.example.castshow.core.domain.SelectAndSortableByName

data class Character(
    val id: Int,
    override val name: String = "",
    val status: String = "",
    val species: String = "",
    val type: String = "",
    val gender: String = "",
    val origin: String = "",
    val location: String = "",
    val image: String = "",
) : SelectAndSortableByName

