package com.galataapplab.easenote.domain.use_case

import com.galataapplab.easenote.domain.model.Note
import com.galataapplab.easenote.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note) {
        repository.deleteNote(note)
    }
}