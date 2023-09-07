package com.example.sqldelightnoteapp.domain.use_case

import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.repository.NoteRepository

class GetNoteById(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}