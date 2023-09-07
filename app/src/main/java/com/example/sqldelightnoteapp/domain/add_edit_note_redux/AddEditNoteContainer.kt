package com.example.sqldelightnoteapp.domain.add_edit_note_redux

import com.example.sqldelightnoteapp.domain.use_case.NoteUseCases
import com.example.sqldelightnoteapp.presentation.add_edit_note.AddEditNoteState
import com.example.sqldelightnoteapp.redux.BaseContainer

class AddEditNoteContainer(
    useCases: NoteUseCases
): BaseContainer<AddEditNoteAction, AddEditNoteState, AddEditNoteSideEffect>(
    initialState = AddEditNoteState(),
    reducer = AddEditNoteReducer(),
    middleware = listOf(
        AddEditEffectMiddleware(),
        NoteSaveMiddleware(useCases)
    ),
)