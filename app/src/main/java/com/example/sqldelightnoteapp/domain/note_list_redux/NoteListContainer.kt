package com.example.sqldelightnoteapp.domain.note_list_redux

import com.example.sqldelightnoteapp.domain.use_case.NoteUseCases
import com.example.sqldelightnoteapp.presentation.note_list.NoteListState
import com.example.sqldelightnoteapp.redux.BaseContainer


class NoteListContainer(
    noteUseCases: NoteUseCases
): BaseContainer<NoteListAction, NoteListState, NoteListSideEffect>(
    initialState = NoteListState(),
    reducer = NoteListReducer(),
    middleware = listOf(
        NoteListEffectMiddleware(),
        NoteLocalDataMiddleware(noteUseCases)
    ),
)