package com.galataapplab.easenote.ui.add_edit_note

sealed class AddEditNoteEvent {
    data class OnTittleChange(val newTitle: String) : AddEditNoteEvent()
    data class SaveNote(val content: String) : AddEditNoteEvent()
}
