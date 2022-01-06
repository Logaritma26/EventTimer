package com.log.eventtimer.presentation.screens.add_event_screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp

@ExperimentalMaterialApi
@Composable
fun ColorTile(
    color: Int,
    colorState: Int,
    onColorSelected: (Int) -> Unit,
) {

    Box(modifier = Modifier.padding(12.dp)) {
        Card(
            modifier = Modifier
                .height(64.dp)
                .width(64.dp),
            shape = RoundedCornerShape(size = 16.dp),
            elevation = 8.dp,
            onClick = { onColorSelected(color) },
            backgroundColor = colorResource(id = color),
            border = if(color == colorState) BorderStroke(6.dp, color = Color.Black) else null
        ) {}
    }
}