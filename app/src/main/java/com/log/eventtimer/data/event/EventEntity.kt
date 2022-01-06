package com.log.eventtimer.data.event

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.log.eventtimer.domain.model.Event
import java.util.*


@Entity
data class EventEntity(
    val title: String,
    val description: String,
    val date: Date,
    val color: Int,
    @PrimaryKey val roomId: Int? = null,
) {
    fun toEvent(): Event = Event(
        title = title,
        description = description,
        date = date,
        color = color,
        roomId = roomId,
    )
}