package com.example.sqldelightnoteapp.di

import android.app.Application
import androidx.room.Room
import com.example.sqldelightnoteapp.domain.repository.NoteRepository
import com.example.sqldelightnoteapp.domain.use_case.AddNote
import com.example.sqldelightnoteapp.domain.use_case.DeleteNote
import com.example.sqldelightnoteapp.domain.use_case.GetAllNotes
import com.example.sqldelightnoteapp.domain.use_case.GetNoteById
import com.example.sqldelightnoteapp.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): com.example.sqldelightnoteapp.data.data_source.NoteDatabase {
        return Room.databaseBuilder(
            app,
            com.example.sqldelightnoteapp.data.data_source.NoteDatabase::class.java,
            com.example.sqldelightnoteapp.data.data_source.NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(noteDatabase: com.example.sqldelightnoteapp.data.data_source.NoteDatabase): NoteRepository {
        return com.example.sqldelightnoteapp.data.repository.NoteRepositoryImpl(
            noteDatabase.noteDao
        )
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getAllNotes = GetAllNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNoteById = GetNoteById(repository)
        )
    }
}