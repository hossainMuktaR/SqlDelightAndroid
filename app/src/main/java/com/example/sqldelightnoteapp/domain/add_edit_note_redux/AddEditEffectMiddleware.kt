package com.example.sqldelightnoteapp.domain.add_edit_note_redux

import com.example.sqldelightnoteapp.presentation.add_edit_note.AddEditNoteState
import com.example.sqldelightnoteapp.redux.Container
import com.example.sqldelightnoteapp.redux.Middleware


class AddEditEffectMiddleware:
    Middleware<AddEditNoteAction, AddEditNoteState, AddEditNoteSideEffect> {
    override suspend fun process(
        action: AddEditNoteAction,
        currentState: AddEditNoteState,
        container: Container<AddEditNoteAction, AddEditNoteState, AddEditNoteSideEffect>
    ) {
        when(action) {

            else -> { }
        }
    }
}
