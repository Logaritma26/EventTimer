package com.log.eventtimer.presentation.screens.saved_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.log.eventtimer.presentation.screens.saved_screen.event_tile.EventTile

@ExperimentalMaterialApi
@Composable
fun SavedScreen(
    viewModel: SavedViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    LaunchedEffect(key1 = true) {
        viewModel.getAllEvent()
    }

    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 12.dp),
        ) {
            items(state) { item ->
                EventTile(
                    event = item,
                    onDelete = { viewModel.deleteEvent(it) },
                )
            }
        }
    }
}




