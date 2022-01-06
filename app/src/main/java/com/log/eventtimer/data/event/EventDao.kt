package com.log.eventtimer.data.event

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface EventDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEvent(event: EventEntity)

    @Query("SELECT * FROM EventEntity")
    fun getAllEvents(): Flow<List<EventEntity>>

    @Delete
    suspend fun deleteEvent(event: EventEntity)

}