package com.core.movieslatest.presentation.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.core.movieslatest.data.ResponseState
import com.core.movieslatest.domain.model.Movie
import com.core.movieslatest.presentation.common.ErrorScreen
import com.seiko.imageloader.rememberAsyncImagePainter
import moe.tlaster.precompose.navigation.Navigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navigator: Navigator,
    mainViewModel: MainViewModel
) {
    mainViewModel.getMovies(1, mapOf())
    var state = mainViewModel.moviesList.collectAsState()
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            MainAppBar()
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Rounded.Add, contentDescription = "Add")
            }
        },

        ) { innerPadding ->

        when (val response =state.value) {
            is ResponseState.Failure -> {
                ErrorScreen()
            }

            ResponseState.Loading -> {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            is ResponseState.Success -> {
                MoviesGrid(response.item, innerPadding.calculateTopPadding())
            }
        }

    }
}

@Composable
fun MoviesGrid(movieList: List<Movie>, topPadding: Dp) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.padding(
            top = topPadding + 20.dp,
            start = 16.dp, end = 16.dp,
            bottom = 10.dp
        ),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(movieList) {
            MoviesCard(it)
        }
    }
}

@Composable
fun MoviesCard(movie: Movie) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(2.dp),
        colors = CardDefaults.cardColors(Color.Black),
        modifier = Modifier.size(width = 143.dp, height = 160.dp),
    ) {
       Image(
            painter =rememberAsyncImagePainter(movie.posterPath) ,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
    }
}


/*
@Composable
fun PreviewMainScreen() {
    val elements = Movie(
        id = 1,
        name = "Spider Man",
        releaseDate = "20/23/11",
        posterPath = "",
        voteAverage = 0.0,
        voteCount = 0
    )
    val movieList = listOf<Movie>(
        elements,
        elements, elements,
        elements, elements,
        elements, elements,
        elements, elements
    )
    MainScreen(ResponseState.Success(movieList))
}*/
