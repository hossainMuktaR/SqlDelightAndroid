package com.example.sqldelightnoteapp.data.repository

import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.repository.NoteRepository


class NoteRepositoryImpl(
    private val noteDao: com.example.sqldelightnoteapp.data.data_source.NoteDao
): NoteRepository {
    override suspend fun getAllNotes(): List<Note> = noteDao.getAllNotes()

    override suspend fun getNoteById(id: Int): Note? = noteDao.getNoteById(id)

    override suspend fun insertNote(note: Note) = noteDao.insertNote(note)

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)

}