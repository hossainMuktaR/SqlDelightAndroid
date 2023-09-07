package com.example.sqldelightnoteapp.data.data_source

import com.example.sqldelightnoteapp.domain.model.Note

interface NoteDao {

    suspend fun getAllNotes(): List<Note>

    suspend fun getNoteById(id: Long): Note?

    suspend fun insertNote(note: Note)

    suspend fun deleteNote(note: Note)

}