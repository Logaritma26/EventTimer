package com.log.eventtimer.presentation.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.log.eventtimer.presentation.navigation.ObjectRoutes.ADD_EVENT_PAGE
import com.log.eventtimer.presentation.navigation.ObjectRoutes.SAVED
import com.log.eventtimer.presentation.screens.add_event_screen.AddEventScreen
import com.log.eventtimer.presentation.screens.saved_screen.SavedScreen

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = SAVED.path(),
        modifier = modifier,
    ) {
        composable(SAVED.path()) {
            SavedScreen()
        }
        composable(ADD_EVENT_PAGE.path()) {
            AddEventScreen(navController = navController)
        }
    }
}