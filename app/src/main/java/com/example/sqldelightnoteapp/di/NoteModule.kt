package com.example.sqldelightnoteapp.di

import android.app.Application
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.sqldelightSpecial.NoteDatabase
import com.example.sqldelightnoteapp.data.data_source.NoteDao
import com.example.sqldelightnoteapp.data.data_source.NoteDaoImpl
import com.example.sqldelightnoteapp.data.repository.NoteRepositoryImpl
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
    fun provideSqlDriver(app: Application): SqlDriver {
        return AndroidSqliteDriver(
            schema = NoteDatabase.Schema,
            context = app,
            name = "noteDatabase.db"
        )
    }

    @Provides
    @Singleton
    fun provideNoteDataBase(sqlDriver: SqlDriver): NoteDatabase {
        return NoteDatabase(sqlDriver)
    }

    @Provides
    @Singleton
    fun provideNoteDao(db: NoteDatabase): NoteDao {
        return NoteDaoImpl(db)
    }
    @Provides
    @Singleton
    fun provideNoteRepository(noteDao: NoteDao): NoteRepository {
        return NoteRepositoryImpl(noteDao)
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