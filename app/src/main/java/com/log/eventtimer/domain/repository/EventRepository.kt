package com.log.eventtimer.domain.repository

import com.log.eventtimer.data.event.EventEntity
import kotlinx.coroutines.flow.Flow

interface EventRepository {

    suspend fun saveEvent(event: EventEntity)

    suspend fun getAllEvents(): Flow<List<EventEntity>>

    suspend fun deleteEvent(event: EventEntity)

}