package com.core.movieslatest.data



sealed class ResponseState<out T> {
    object Loading : ResponseState<Nothing>()
    data class Failure(val error: Throwable) : ResponseState<Nothing>()
    data class Success<T>(val item: T) : ResponseState<T>()

}


