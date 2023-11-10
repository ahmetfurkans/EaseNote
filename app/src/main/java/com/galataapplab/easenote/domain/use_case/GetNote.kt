package com.galataapplab.easenote.domain.use_case

import com.galataapplab.easenote.domain.model.Note
import com.galataapplab.easenote.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(noteId: Int): Note? {
        return repository.getNote(noteId)
    }
}