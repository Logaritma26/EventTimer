package com.log.eventtimer.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.log.eventtimer.presentation.navigation.Navigation
import com.log.eventtimer.presentation.navigation.ObjectRoutes.ADD_EVENT_PAGE
import com.log.eventtimer.presentation.navigation.ObjectRoutes.SAVED
import com.log.eventtimer.ui.theme.EventTimerTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalAnimationApi
@ExperimentalMaterialApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            ProvideWindowInsets {
                EventTimerTheme {

                    val navController: NavHostController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()

                    Scaffold(
                        floatingActionButton = {
                            when (navBackStackEntry?.destination?.route) {
                                SAVED.path() -> {
                                    FloatingActionButton(
                                        onClick = { navController.navigate(ADD_EVENT_PAGE.path()) }
                                    ) {
                                        Icon(
                                            imageVector = Icons.Filled.Add,
                                            contentDescription = "Add Event Icon",
                                        )
                                    }
                                }
                                else -> {}
                            }
                        }
                    ) {
                        Navigation(
                            modifier = Modifier.padding(it),
                            navController = navController,
                        )
                    }
                }
            }
        }
    }
}
