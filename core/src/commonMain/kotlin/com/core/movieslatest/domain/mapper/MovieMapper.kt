package com.core.movieslatest.domain.mapper

import com.core.movieslatest.data.dto.MovieResponse
import com.core.movieslatest.domain.model.Movie
import com.core.movieslatest.util.toPosterUrl

class MovieMapper  constructor() : Mapper<MovieResponse, Movie> {
    override fun map(input: MovieResponse): Movie = Movie(
        id = input.id,
        name = input.name,
        releaseDate = input.firstAirDate.orEmpty(),
        posterPath = input.posterPath.orEmpty().toPosterUrl(),
        voteAverage = input.voteAverage,
        voteCount = input.voteCount,
    )
}
