package com.galataapplab.easenote.ui.add_edit_note

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galataapplab.easenote.core.ui.theme.LocalSpacing
import com.galataapplab.easenote.core.util.UiEvent
import com.galataapplab.easenote.ui.add_edit_note.components.CustomTextEditor
import com.galataapplab.easenote.ui.add_edit_note.components.EditorControls
import com.galataapplab.easenote.ui.add_edit_note.components.Toolbar
import com.galataapplab.easenote.ui.add_edit_note.components.TransparentHintTextField
import com.mohamedrejeb.richeditor.model.rememberRichTextState
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AddEditNoteScreen(
    viewModel: AddEditNoteViewModel = hiltViewModel(),
    navController: NavController,
    scaffoldState: ScaffoldState
) {

    val state = viewModel.state
    val spacing = LocalSpacing.current
    val richTextState = rememberRichTextState()

    LaunchedEffect(key1 = true) {
        richTextState.setHtml(state.content)
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.NavigateUp -> {
                    navController.navigateUp()
                }

                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }

                is UiEvent.Success -> {
                }
            }
        }
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = spacing.spaceMedium, vertical = spacing.spaceMedium),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Toolbar(onNavigateUp = { navController.navigateUp() },
                    onSaveClick = { viewModel.onEvent(AddEditNoteEvent.SaveNote(richTextState.toHtml())) })
                TransparentHintTextField(text = state.title,
                    textStyle = MaterialTheme.typography.h1,
                    hint = "Tittle...",
                    onValueChange = {
                        viewModel.onEvent(
                            AddEditNoteEvent.OnTittleChange(it)
                        )
                    })
                CustomTextEditor(
                    richTextState = richTextState,
                )
            }
            EditorControls(modifier = Modifier
                .fillMaxWidth()
                .height(45.dp), onBoldClick = {
                richTextState.toggleSpanStyle(SpanStyle(fontWeight = FontWeight.Bold))
            }, onItalicClick = {
                richTextState.toggleSpanStyle(SpanStyle(fontStyle = FontStyle.Italic))
            }, onUnderlineClick = {
                richTextState.toggleSpanStyle(SpanStyle(textDecoration = TextDecoration.Underline))
            }, onStartAlignClick = {
                richTextState.toggleParagraphStyle(ParagraphStyle(textAlign = TextAlign.Start))
            }, onEndAlignClick = {
                richTextState.toggleParagraphStyle(ParagraphStyle(textAlign = TextAlign.End))
            }, onCenterAlignClick = {
                richTextState.toggleParagraphStyle(ParagraphStyle(textAlign = TextAlign.Center))
            }, onListSelected = {
                richTextState.toggleUnorderedList()
            })
        }
    }
}
