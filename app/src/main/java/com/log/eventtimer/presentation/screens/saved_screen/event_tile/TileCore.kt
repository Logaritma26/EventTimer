package com.log.eventtimer.presentation.screens.saved_screen.event_tile

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.log.eventtimer.domain.model.Event
import java.util.*

@Composable
fun BasicTile(
    event: Event,
    currentTime: Long,
) {
    val chrData = calculateTime(event.date, currentTime)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = event.title,
            style = MaterialTheme.typography.body1,
        )
        if (chrData.days != null) {
            Text(
                text = "${chrData.days}d ${chrData.hours}:${chrData.minutes}:${chrData.seconds}",
                style = MaterialTheme.typography.body2,
            )
        } else {
            Text(
                text = "${chrData.hours}:${chrData.minutes}:${chrData.seconds}",
                style = MaterialTheme.typography.body2,
            )
        }
    }
}

@Composable
fun ExpandedTile(
    event: Event,
    currentTime: Long,
) {
    val chrData = calculateTime(event.date, currentTime)

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = event.title,
                style = MaterialTheme.typography.body1,
            )
            if (chrData.days != null) {
                Text(
                    text = "${chrData.days}d ${chrData.hours}:${chrData.minutes}:${chrData.seconds}",
                    style = MaterialTheme.typography.body2,
                )
            } else {
                Text(
                    text = "${chrData.hours}:${chrData.minutes}:${chrData.seconds}",
                    style = MaterialTheme.typography.body2,
                )
            }
        }
        Text(
            text = event.description,
            style = MaterialTheme.typography.overline,
        )
    }
}

private fun calculateTime(
    date: Date,
    currentTime: Long,
): ChrData {
    val time = currentTime - date.time
    val seconds = ((time / 1000) % 60).toInt()
    val minutes = (time / (1000 * 60) % 60).toInt()
    val hours = (time / (1000 * 60 * 60) % 24).toInt()
    val days = (time / (1000 * 60 * 60 * 24)).toInt()

    return ChrData(
        seconds = if (seconds > 9) seconds.toString() else "0$seconds",
        minutes = if (minutes > 9) minutes.toString() else "0$minutes",
        hours = if (hours > 9) hours.toString() else "0$hours",
        days = if (days > 0) days.toString() else null,
    )
}

private data class ChrData(
    val seconds: String,
    val minutes: String,
    val hours: String,
    val days: String?,
)