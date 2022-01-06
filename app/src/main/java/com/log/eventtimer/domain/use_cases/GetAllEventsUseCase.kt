package com.log.eventtimer.domain.use_cases

import com.log.eventtimer.di.DefaultDispatcher
import com.log.eventtimer.domain.model.Event
import com.log.eventtimer.domain.repository.EventRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAllEventsUseCase @Inject constructor(
    private val repository: EventRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(): Flow<List<Event>> = coroutineScope {
        repository.getAllEvents().map {
            it.map { eventEntity ->
                eventEntity.toEvent()
            }
        }.flowOn(defaultDispatcher)
    }
}