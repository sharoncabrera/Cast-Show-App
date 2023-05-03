package com.example.castshow.core.network

import com.example.castshow.core.data.local.model.ApiResponse
import com.example.castshow.core.data.local.model.CharacterResponse
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiClient {
    companion object {

        private var nextUrlPage: String? = null
        private var prevUrlPage: String? = null

        private const val BASE_URL = "https://rickandmortyapi.com/api/character"

        private val client = HttpClient(CIO) {
            install(ContentNegotiation) {
                json(Json { ignoreUnknownKeys = true })
            }
        }
    }

    suspend fun getData(status: String, gender: String): Result<List<CharacterResponse>> {

        if (nextUrlPage.isNullOrEmpty() && !prevUrlPage.isNullOrEmpty()) {
            return Result.success(listOf())
        }

        val response =
            if (nextUrlPage.isNullOrEmpty()) {
                client.get {
                    url(BASE_URL)
                    parameter("status", status)
                    parameter("gender", gender)
                }
            } else {
                nextUrlPage?.let {
                    client.get(it) {
                        parameter("status", status)
                        parameter("gender", gender)
                    }
                }

            }

        return response?.let {
            if (it.status.isSuccess()) {
                val result: ApiResponse = it.body()
                nextUrlPage = result.component1().next
                prevUrlPage = result.component1().prev
                Result.success(result.results)
            } else {
                Result.failure(error("Something went wrong"))
            }
        } ?: run { Result.failure(error("Something went wrong")) }

    }
}