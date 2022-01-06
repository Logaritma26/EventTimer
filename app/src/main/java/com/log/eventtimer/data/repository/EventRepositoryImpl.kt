package com.log.eventtimer.data.repository

import com.log.eventtimer.data.event.EventDao
import com.log.eventtimer.data.event.EventEntity
import com.log.eventtimer.di.IoDispatcher
import com.log.eventtimer.domain.repository.EventRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class EventRepositoryImpl @Inject constructor(
    private val dao: EventDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : EventRepository {

    override suspend fun saveEvent(event: EventEntity) = withContext(ioDispatcher) {
        dao.insertEvent(event = event)
    }

    override suspend fun getAllEvents(): Flow<List<EventEntity>> =
        dao.getAllEvents().flowOn(ioDispatcher)


    override suspend fun deleteEvent(event: EventEntity) {
        withContext(ioDispatcher) {
            dao.deleteEvent(event = event)
        }
    }
}