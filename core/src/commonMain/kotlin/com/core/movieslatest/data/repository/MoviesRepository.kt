package com.core.movieslatest.data.repository

import com.core.movieslatest.data.ResponseState
import com.core.movieslatest.data.datasource.RemoteDataSource
import com.core.movieslatest.domain.mapper.MovieMapper
import com.core.movieslatest.domain.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class MoviesRepository  constructor(
    private val remoteDataSource: RemoteDataSource,
    private val moviesMapper: MovieMapper,
    private val workDispatcher: CoroutineDispatcher = Dispatchers.Main
) {


    fun getMovies(
        pageNumber: Int,
        options: Map<String, String>
    ): Flow<ResponseState<List<Movie>>> {
        return flow<ResponseState<List<Movie>>> {
            emit(ResponseState.Loading)
            kotlin.runCatching { remoteDataSource.fetchMovies(pageNumber, options) }.onSuccess {
                emit(ResponseState.Success(it.movies.map { moviesMapper.map(it) }))
            }.onFailure {
                emit(ResponseState.Failure(it))
            }
        }.flowOn(workDispatcher)
    }

}