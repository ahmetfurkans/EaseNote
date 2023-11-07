package com.galataapplab.easenote.ui.add_edit_note

import androidx.compose.ui.unit.IntSize

sealed class AddEditNoteEvent {
    data class OnTittleChange(val newTitle: String) : AddEditNoteEvent()
}
