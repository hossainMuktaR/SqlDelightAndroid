package com.example.sqldelightnoteapp.domain.use_case

import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.repository.NoteRepository


class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}