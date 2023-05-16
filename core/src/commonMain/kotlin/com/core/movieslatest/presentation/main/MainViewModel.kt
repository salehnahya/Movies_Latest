package com.core.movieslatest.presentation.main


import com.core.movieslatest.data.ResponseState
import com.core.movieslatest.data.repository.MoviesRepository
import com.core.movieslatest.domain.model.Movie
import com.core.movieslatest.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class MainViewModel constructor(
    private val repository: MoviesRepository
) : ViewModel() {

    val moviesList = MutableStateFlow<ResponseState<List<Movie>>>(ResponseState.Success(listOf()))


    fun getMovies(
        pageNumber: Int,
        options: Map<String, String>
    ) {
        viewModelScope.launch {
            repository.getMovies(pageNumber, options).distinctUntilChanged().collect {
                moviesList.emit(it)
            }
        }
    }

}