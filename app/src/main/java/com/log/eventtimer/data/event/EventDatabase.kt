package com.log.eventtimer.data.event

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [EventEntity::class],
    version = 1,
)
@TypeConverters(EventConverter::class)
abstract class EventDatabase : RoomDatabase() {
    abstract val dao: EventDao
}