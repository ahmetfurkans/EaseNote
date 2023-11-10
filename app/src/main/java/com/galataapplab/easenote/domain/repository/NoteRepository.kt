package com.galataapplab.easenote.domain.repository

import com.galataapplab.easenote.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

    suspend fun getNote(noteId: Int): Note?
}