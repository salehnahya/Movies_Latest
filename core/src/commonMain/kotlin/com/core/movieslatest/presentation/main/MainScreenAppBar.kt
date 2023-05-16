package com.core.movieslatest.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun MainAppBar() {
    var text by rememberSaveable { mutableStateOf<String>("") }
    Column(Modifier.fillMaxWidth()) {
        Text(
            text = "What would you like to watch?",
            modifier = Modifier.padding(25.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.onSecondary
        )

       /* SearchBar(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            query = text,
            onQueryChange = { text = it },
            onSearch = { active = false },
            placeholder = { Text("Serach") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = SearchBarDefaults.inputFieldShape,
            active = false,
            onActiveChange = {}
        ){}*/


    }

}