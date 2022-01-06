package com.log.eventtimer.domain.use_cases

import com.log.eventtimer.di.ApplicationScope
import com.log.eventtimer.domain.model.Event
import com.log.eventtimer.domain.repository.EventRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class SaveEventUseCase @Inject constructor(
    @ApplicationScope private val externalScope: CoroutineScope,
    private val repository: EventRepository
) {
    operator fun invoke(event: Event) = externalScope.launch {
        repository.saveEvent(event = event.toEntity())
    }
}