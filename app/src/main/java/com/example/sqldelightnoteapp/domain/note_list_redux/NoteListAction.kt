package com.example.sqldelightnoteapp.domain.note_list_redux

import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.utils.NoteOrder
import com.example.sqldelightnoteapp.redux.Action


sealed class NoteListAction: Action {
    data class AllNoteLoaded(val notes: List<Note>, val order: NoteOrder): NoteListAction()
    data class FetchOrderedNoteList(val order: NoteOrder): NoteListAction()
    data class DeleteNote(val note: Note, val order: NoteOrder): NoteListAction()
    data class RestoreNote(val note: Note, val order: NoteOrder): NoteListAction()
    object ToggleOrderSection: NoteListAction()
    data class GoNoteUpdateScreen(val noteId: Int, val noteColor: Int): NoteListAction()
    object GoAddEditScreen: NoteListAction()
}
