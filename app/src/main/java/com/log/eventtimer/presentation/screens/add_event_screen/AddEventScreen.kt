package com.log.eventtimer.presentation.screens.add_event_screen

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.log.eventtimer.presentation.screens.add_event_screen.components.ColorTile
import com.log.eventtimer.presentation.util.composables.textfield.CustomTextField
import com.log.eventtimer.presentation.util.composables.textfield.TextFieldState

@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun AddEventScreen(
    navController: NavController,
    viewModel: AddEventViewModel = hiltViewModel(),
) {
    val state: SaveEventState = viewModel.state.value

    val titleState: TextFieldState = remember { TextFieldState(pHint = "Add event title") }
    val descState: TextFieldState = remember { TextFieldState(pHint = "Add event description") }
    var colorState by remember { mutableStateOf(colorList.first()) }

    fun saveEvent() {
        viewModel.setState(
            state = state.copy(
                title = titleState.text,
                desc = descState.text,
                color = colorState,
            )
        )
        viewModel.saveEvent()
        navController.popBackStack()
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp, top = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                state = titleState,
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                state = descState
            )
            Spacer(modifier = Modifier.height(32.dp))
            LazyRow(
                modifier = Modifier.fillMaxWidth()
            ) {
                items(colorList) { color ->
                    ColorTile(
                        color = color,
                        colorState = colorState,
                        onColorSelected = { colorState = it }
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    modifier = Modifier.padding(24.dp),
                    onClick = ::saveEvent,
                ) {
                    Text(
                        text = "Save",
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }
    }
}

