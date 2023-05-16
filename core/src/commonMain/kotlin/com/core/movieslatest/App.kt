package com.core.movieslatest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.core.movieslatest.data.repository.MoviesRepository
import com.core.movieslatest.domain.datasource.datasource.RemoteDataSourceImpl
import com.core.movieslatest.domain.mapper.MovieMapper
import com.core.movieslatest.http.HttpClientFactory
import com.core.movieslatest.presentation.main.MainScreen
import com.core.movieslatest.presentation.main.MainViewModel
import com.core.movieslatest.ui.theme.MoviesTheme

@Composable
fun App() {
    val viewModel = mainViewModel()
    viewModel.getMovies(1, mapOf())
      val responseStateState = viewModel.moviesList.collectAsState()





}

fun mainViewModel(): MainViewModel {
    val remoteDataSource = RemoteDataSourceImpl(httpClientFactory = HttpClientFactory())
    val moviesMapper = MovieMapper()
    val repository = MoviesRepository(remoteDataSource, moviesMapper)

    return MainViewModel(repository)
}