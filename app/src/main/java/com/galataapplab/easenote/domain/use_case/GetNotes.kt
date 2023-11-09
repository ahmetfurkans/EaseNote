package com.galataapplab.easenote.domain.use_case

import com.galataapplab.easenote.domain.model.Note
import com.galataapplab.easenote.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotes(
    private val repository: NoteRepository
) {
    operator fun invoke(): Flow<List<Note>> {
        return repository.getNotes()
    }
}