package com.galataapplab.easenote.domain.use_case

data class NoteUseCases(
    val getNotes: GetNotes, val deleteNote: DeleteNote, val addNote: AddNote
)