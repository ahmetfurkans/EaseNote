package com.galataapplab.easenote.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galataapplab.easenote.domain.model.Note
import com.galataapplab.easenote.domain.use_case.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    private var getNotesJob: Job? = null
    private var recentlyDeletedNote: Note? = null

    init {
        getNotes()
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteNote -> {
                viewModelScope.launch {
                    noteUseCases.deleteNote(event.note)
                    recentlyDeletedNote = event.note
                }
            }

            is HomeEvent.RestoreNote -> {
                viewModelScope.launch {
                    noteUseCases.addNote(recentlyDeletedNote ?: return@launch)
                    recentlyDeletedNote = null
                }
            }
        }
    }

    private fun getNotes() {
        getNotesJob?.cancel()

        getNotesJob = noteUseCases.getNotes().onEach {
            state = state.copy(
                notes = it
            )
        }.launchIn(viewModelScope)
    }
}