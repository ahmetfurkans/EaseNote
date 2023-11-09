package com.galataapplab.easenote.di

import android.app.Application
import androidx.room.Room
import com.galataapplab.easenote.data.local.NoteDatabase
import com.galataapplab.easenote.data.repository.NoteRepositoryImpl
import com.galataapplab.easenote.domain.repository.NoteRepository
import com.galataapplab.easenote.domain.use_case.AddNote
import com.galataapplab.easenote.domain.use_case.DeleteNote
import com.galataapplab.easenote.domain.use_case.GetNotes
import com.galataapplab.easenote.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.dao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}