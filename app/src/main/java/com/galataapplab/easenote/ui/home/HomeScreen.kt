package com.galataapplab.easenote.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarResult
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.galataapplab.easenote.R
import com.galataapplab.easenote.core.ui.theme.LocalSpacing
import com.galataapplab.easenote.core.ui.theme.MidnightBlue
import com.galataapplab.easenote.core.util.Routes
import com.galataapplab.easenote.ui.home.components.EmptyNoteScreen
import com.galataapplab.easenote.ui.home.components.NoteCard
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    viewModel: HomeViewModel = hiltViewModel(),
) {

    val spacing = LocalSpacing.current
    val scope = rememberCoroutineScope()
    val state = viewModel.state

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
                .padding(horizontal = spacing.spaceMedium, vertical = spacing.spaceMedium),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Default.DensityMedium,
                    contentDescription = "dropdown menu",
                    tint = MaterialTheme.colors.primary
                )
            }
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            if (state.notes.isEmpty()) EmptyNoteScreen(
                modifier = Modifier.fillMaxHeight()
            ) else {
                LazyColumn(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    items(state.notes) { note ->
                        NoteCard(note = note, navigateToEditNote = {
                            navController.navigate(
                                Routes.ADD_EDIT_NOTE + "?noteId=${note.uid}"
                            )
                        }, onDeleteClick = {
                            viewModel.onEvent(HomeEvent.DeleteNote(note))
                            scope.launch {
                                val result = scaffoldState.snackbarHostState.showSnackbar(
                                    message = "Note deleted", actionLabel = "Undo"
                                )
                                if (result == SnackbarResult.ActionPerformed) {
                                    viewModel.onEvent(HomeEvent.RestoreNote)
                                }
                            }
                        })
                        Spacer(modifier = Modifier.height(spacing.spaceMedium))
                    }
                }
            }
        }
    }
}

