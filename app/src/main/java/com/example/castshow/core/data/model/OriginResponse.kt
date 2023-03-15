package com.example.castshow.core.data.model

import kotlinx.serialization.Serializable

@Serializable
data class OriginResponse(
    var name: String,
    var url: String
)
