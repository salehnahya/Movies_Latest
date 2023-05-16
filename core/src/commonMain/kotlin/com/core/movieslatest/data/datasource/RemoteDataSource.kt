package com.core.movieslatest.data.datasource

import com.core.movieslatest.data.dto.MoviesResponse

interface RemoteDataSource {

    suspend fun fetchMovies(pageNumber: Int, options: Map<String, String>): MoviesResponse


}


