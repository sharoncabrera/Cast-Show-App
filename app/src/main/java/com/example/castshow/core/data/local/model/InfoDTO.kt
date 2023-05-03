package com.example.castshow.core.data.local.model

import kotlinx.serialization.Serializable

@Serializable
data class InfoDTO(
    var count: Int,
    var pages: Int,
    var next: String?,
    var prev: String?
)
