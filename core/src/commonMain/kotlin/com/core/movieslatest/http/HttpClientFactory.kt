package com.core.movieslatest.http

import io.ktor.client.HttpClient

expect class HttpClientFactory constructor() {
     fun create(): HttpClient
}