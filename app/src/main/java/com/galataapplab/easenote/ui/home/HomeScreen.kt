package com.galataapplab.easenote.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import com.galataapplab.easenote.R
import com.galataapplab.easenote.core.ui.theme.MidnightBlue
import com.galataapplab.easenote.core.util.Routes

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController, scaffoldState: ScaffoldState
) {
    Scaffold(scaffoldState = scaffoldState, floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(Routes.ADD_EDIT_NOTE) },
            backgroundColor = MidnightBlue
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = stringResource(R.string.add_note),
                tint = Color.White
            )
        }
    }) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // TODO = control if note is empty
            EmptyNoteScreen(Modifier)
        }
    }

}