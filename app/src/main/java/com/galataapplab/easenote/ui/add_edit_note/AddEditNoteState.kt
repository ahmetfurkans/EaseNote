package com.galataapplab.easenote.ui.add_edit_note

data class AddEditNoteState(
    val title: String = "",
    val isTitleHintVisible: Boolean = true,
    val content: String = ""
)