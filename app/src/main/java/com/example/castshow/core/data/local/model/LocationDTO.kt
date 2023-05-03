package com.example.castshow.core.data.local.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationDTO(
    var name: String,
    var url: String
)
