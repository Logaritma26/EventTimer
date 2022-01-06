package com.log.eventtimer.presentation.screens.add_event_screen

import com.log.eventtimer.R

data class SaveEventState(
    val title: String = "",
    val desc: String = "",
    val color: Int = 0,
)

val colorList = listOf(
    R.color.lightGreen,
    R.color.creme,
    R.color.red,
    R.color.purple,
    R.color.lightBlue,
    R.color.forestGreen,
    R.color.orange,
    R.color.greyBlue,
    R.color.petrolBlue,
    R.color.green,
)

