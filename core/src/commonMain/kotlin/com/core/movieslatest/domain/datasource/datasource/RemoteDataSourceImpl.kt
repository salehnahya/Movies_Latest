package com.core.movieslatest.domain.datasource.datasource

import com.core.movieslatest.data.datasource.RemoteDataSource
import com.core.movieslatest.data.dto.MoviesResponse
import com.core.movieslatest.http.HttpClientFactory
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.charsets.Charsets
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer


class RemoteDataSourceImpl constructor(httpClientFactory: HttpClientFactory) :
    RemoteDataSource {
    private val client = httpClientFactory.create()
     private val BASE_URL = "https://api.themoviedb.org/3/"
    override suspend fun fetchMovies(
        pageNumber: Int,
        options: Map<String, String>
    ): MoviesResponse {

        return client.get("${BASE_URL}discover/movie") {
            contentType(ContentType.Application.Json)
            parameter("api_key", "9487082a53af88e1866c341355155846")
            parameter("page", pageNumber)
        }.bodyAsText(Charsets.UTF_8).convertToDataClass<MoviesResponse>()
    }

}

internal inline fun <reified R : Any> String.convertToDataClass() =
    Json {
        ignoreUnknownKeys = true
    }.decodeFromString<R>(serializer(),this)



