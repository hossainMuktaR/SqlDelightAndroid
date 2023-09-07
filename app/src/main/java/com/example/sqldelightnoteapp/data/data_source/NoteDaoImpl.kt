package com.example.sqldelightnoteapp.data.data_source

import com.example.sqldelightSpecial.NoteDatabase
import com.example.sqldelightnoteapp.domain.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class NoteDaoImpl(
    db: NoteDatabase
): NoteDao {

    private val queries = db.noteEntityQueries
    override suspend fun getAllNotes(): List<Note> {
        return withContext(Dispatchers.IO) {
            queries.getAllNotes().executeAsList().map { it.toNote() }
        }
    }

    override suspend fun getNoteById(id: Long): Note? {
        return withContext(Dispatchers.IO) {
            queries.getNoteById(id).executeAsOneOrNull()!!.toNote()
        }
    }

    override suspend fun insertNote(note: Note) {
        withContext(Dispatchers.IO) {
            queries.insertNote(
                note.id,
                note.title,
                note.content,
                note.timeStamp,
                note.color.toLong()
            )
        }
    }

    override suspend fun deleteNote(note: Note) {
        return withContext(Dispatchers.IO) {
            queries.deleteNote(note.id!!)
        }
    }

}