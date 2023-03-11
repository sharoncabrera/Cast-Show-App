package com.example.castshow.core.data

import kotlinx.serialization.Serializable

@Serializable
data class Info(
    var count: Int,
    var pages: Int,
    var next: String,
    var prev: String
)
