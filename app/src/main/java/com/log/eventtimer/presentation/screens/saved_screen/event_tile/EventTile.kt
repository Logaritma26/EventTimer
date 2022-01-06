package com.log.eventtimer.presentation.screens.saved_screen.event_tile

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.log.eventtimer.domain.model.Event
import kotlinx.coroutines.delay
import kotlin.math.roundToInt

@ExperimentalMaterialApi
@Composable
fun EventTile(
    event: Event,
    onDelete: (Event) -> Unit,
) {
    var time by remember { mutableStateOf(System.currentTimeMillis()) }
    var expanded by remember { mutableStateOf(false) }
    val height = animateDpAsState(if (expanded) 96.dp else 64.dp)

    val widthOfBackgroundSwipe = 64.dp
    val swipeAbleState = rememberSwipeableState(initialValue = 0)
    val sizePx = with(LocalDensity.current) { widthOfBackgroundSwipe.toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1)


    LaunchedEffect(key1 = true) {
        while (true) {
            delay(100L)
            time = System.currentTimeMillis()
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp, 2.dp)
            .height(height.value + 20.dp)
            .clip(RoundedCornerShape(8.dp))
            .swipeable(
                state = swipeAbleState,
                anchors = anchors,
                thresholds = { _, _ ->
                    FractionalThreshold(0.2f)
                },
                orientation = Orientation.Horizontal
            )
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp, 10.dp)
                .height(height.value)
                .width(widthOfBackgroundSwipe),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { onDelete(event) },
                modifier = Modifier
                    .height(24.dp)
                    .width(24.dp)
                    .clip(CircleShape)
                    .background(Color.Transparent)
            ) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color.Red
                )
            }
        }

        Card(
            modifier = Modifier
                .padding(8.dp, 10.dp)
                .offset { IntOffset(swipeAbleState.offset.value.roundToInt(), 0) }
                .fillMaxWidth()
                .height(height.value),
            shape = RoundedCornerShape(8.dp),
            elevation = 6.dp,
            onClick = {
                expanded = !expanded
            },
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.Top,
            ) {
                Box(
                    modifier = Modifier
                        .height(height.value)
                        .width(24.dp)
                        .background(color = colorResource(id = event.color))
                        .clip(shape = RoundedCornerShape(8.dp)),
                )
                Spacer(modifier = Modifier.width(24.dp))
                Box(modifier = Modifier.weight(1f, true)) {
                    if (expanded) {
                        ExpandedTile(event, time)
                    } else {
                        BasicTile(event, time)
                    }
                }
                Spacer(modifier = Modifier.width(24.dp))
            }
        }
    }
}
