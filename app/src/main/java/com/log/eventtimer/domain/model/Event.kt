package com.log.eventtimer.domain.model

import com.log.eventtimer.data.event.EventEntity
import java.util.*

data class Event(
    val title: String,
    val description: String,
    val date: Date,
    val color: Int,
    val roomId: Int? = null,
) {
    fun toEntity(): EventEntity = EventEntity(
        title = title,
        description = description,
        date = date,
        color = color,
        roomId = roomId,
    )
}
