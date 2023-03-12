package com.example.castshow.core.data

import kotlinx.serialization.Serializable

@Serializable
data class LocationResponse(
    var name: String,
    var url: String
)
