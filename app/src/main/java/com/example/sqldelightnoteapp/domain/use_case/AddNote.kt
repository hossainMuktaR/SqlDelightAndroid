package com.example.sqldelightnoteapp.domain.use_case

import com.example.sqldelightnoteapp.domain.model.InvalidNoteException
import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.repository.NoteRepository


class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()){
            throw InvalidNoteException("The title of the note are empty")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content of the note are empty")
        }
        repository.insertNote(note)
    }
}