package com.galataapplab.easenote.ui.home

import com.galataapplab.easenote.domain.model.Note

sealed class HomeEvent {
    data class DeleteNote(val note: Note) : HomeEvent()
    data object RestoreNote : HomeEvent()
}