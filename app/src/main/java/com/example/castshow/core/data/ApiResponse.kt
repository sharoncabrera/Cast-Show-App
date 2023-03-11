package com.example.castshow.core.data

import kotlinx.serialization.Serializable


@Serializable
data class ApiResponse(var info: Info, var results: List<Character>)
