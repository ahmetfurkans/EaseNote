package com.galataapplab.easenote.core.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.galataapplab.easenote.core.util.Routes
import com.galataapplab.easenote.ui.add_edit_note.AddEditNoteScreen
import com.galataapplab.easenote.ui.home.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController, scaffoldState: ScaffoldState
) {
    NavHost(navController = navController, startDestination = Routes.HOME, modifier = Modifier.fillMaxSize()) {
        composable(Routes.HOME) {
            HomeScreen(navController = navController, scaffoldState)
        }
        composable(
            route = Routes.ADD_EDIT_NOTE + "?noteId={noteId}", arguments = listOf(navArgument(
                name = "noteId"
            ) {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            AddEditNoteScreen()
        }
    }
}