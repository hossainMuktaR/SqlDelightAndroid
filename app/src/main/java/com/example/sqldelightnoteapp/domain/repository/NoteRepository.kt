package com.example.sqldelightnoteapp.domain.repository

import com.example.sqldelightnoteapp.domain.model.Note


interface NoteRepository {

    suspend fun getAllNotes(): List<Note>

    suspend fun getNoteById(id: Long): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)
}