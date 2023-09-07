package com.example.sqldelightnoteapp.domain.note_list_redux

import com.example.sqldelightnoteapp.presentation.note_list.NoteListState
import com.example.sqldelightnoteapp.redux.Reducer

class NoteListReducer : Reducer<NoteListAction, NoteListState> {
    override fun reduce(
        action: NoteListAction,
        currentState: NoteListState,
    ): NoteListState {
        return when(action) {
            is NoteListAction.AllNoteLoaded -> {
                currentState.copy(
                    notes = action.notes,
                    noteOrder = action.order
                )
            }
            is NoteListAction.ToggleOrderSection -> {
                currentState.copy(
                    isOrderSectionVisible = !currentState.isOrderSectionVisible
                )
            }
            is NoteListAction.DeleteNote -> {
                currentState.copy(
                    recentlyDeletedNote = action.note
                )
            }
            is NoteListAction.RestoreNote -> {
                currentState.copy(
                    recentlyDeletedNote = null
                )
            }

            else -> currentState
        }
    }


}