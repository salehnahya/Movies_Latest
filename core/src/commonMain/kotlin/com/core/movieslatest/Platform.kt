package com.core.movieslatest

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform