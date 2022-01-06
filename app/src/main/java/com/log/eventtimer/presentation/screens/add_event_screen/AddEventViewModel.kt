package com.log.eventtimer.presentation.screens.add_event_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.log.eventtimer.domain.model.Event
import com.log.eventtimer.domain.use_cases.SaveEventUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject

@HiltViewModel
class AddEventViewModel @Inject constructor(
    private val saveEventUseCase: SaveEventUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(SaveEventState())
    val state: State<SaveEventState> get() = _state

    fun setState(state: SaveEventState) { _state.value = state }

    fun saveEvent() {
        val event = Event(
            title = state.value.title,
            description = state.value.desc,
            color = state.value.color,
            date = Date(System.currentTimeMillis())
        )
        saveEventUseCase(event = event)
    }
}