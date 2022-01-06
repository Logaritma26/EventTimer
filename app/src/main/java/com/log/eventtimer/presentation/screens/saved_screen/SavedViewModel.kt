package com.log.eventtimer.presentation.screens.saved_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.log.eventtimer.domain.model.Event
import com.log.eventtimer.domain.use_cases.DeleteEventUseCase
import com.log.eventtimer.domain.use_cases.GetAllEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SavedViewModel @Inject constructor(
    private val getAllEventsUseCase: GetAllEventsUseCase,
    private val deleteEventUseCase: DeleteEventUseCase,
) : ViewModel() {

    private val _state = mutableStateOf<List<Event>>(listOf())
    val state: State<List<Event>> get() = _state

    suspend fun getAllEvent() {
        getAllEventsUseCase().onEach {
            _state.value = it
        }.launchIn(viewModelScope)
    }

    fun deleteEvent(event: Event) = deleteEventUseCase(event)

}