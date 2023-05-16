package com.core.movieslatest.domain.mapper

import com.core.movieslatest.data.dto.MovieResponse

interface Mapper<Input, Output> {
    fun map(input: MovieResponse): Output
}
