package com.example.castshow.core.data.local.model

import kotlinx.serialization.Serializable


@Serializable
data class ApiDTO(var info: InfoDTO, var results: List<CharacterDTO>)
