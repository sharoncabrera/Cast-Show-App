package com.example.castshow.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    var name: String,
    var url: String
)
