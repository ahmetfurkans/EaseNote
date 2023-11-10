package com.galataapplab.easenote.ui.add_edit_note

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galataapplab.easenote.core.util.UiEvent
import com.galataapplab.easenote.domain.model.InvalidNoteException
import com.galataapplab.easenote.domain.model.Note
import com.galataapplab.easenote.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditNoteViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(AddEditNoteState())
        private set

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var currentNoteId: Int? = null

    init {
        savedStateHandle.get<Int>("noteId")?.let { noteId ->
            if (noteId != -1) {
                viewModelScope.launch {
                    noteUseCases.getNote(noteId)?.also { note ->
                        currentNoteId = note.uid
                        state = state.copy(
                            title = note.title,
                            content = note.content
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: AddEditNoteEvent) {
        when (event) {
            is AddEditNoteEvent.OnTittleChange -> {
                state = state.copy(
                    title = event.newTitle, isTitleHintVisible = event.newTitle.isEmpty()
                )
            }

            is AddEditNoteEvent.SaveNote -> {
                saveNote(content = event.content)
            }
        }
    }

    private fun saveNote(content: String) {
        viewModelScope.launch {
            try {
                noteUseCases.addNote(
                    Note(
                        title = state.title,
                        content = content,
                        timeStamp = System.currentTimeMillis(),
                        uid = currentNoteId
                    )
                )
                state = state.copy(content = content)
                _uiEvent.send(UiEvent.ShowSnackbar("Note saved successfully"))
            } catch (e: InvalidNoteException) {
                _uiEvent.send(UiEvent.ShowSnackbar(e.message ?: "Couldn't save note"))
            }
        }
    }

}