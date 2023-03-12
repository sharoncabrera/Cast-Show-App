package com.example.castshow.core.data

import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    var count: Int,
    var pages: Int,
    var next: String?,
    var prev: String?
)
