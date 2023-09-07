package com.example.sqldelightnoteapp.presentation.note_list

import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.domain.utils.NoteOrder
import com.example.sqldelightnoteapp.domain.utils.OrderType
import com.example.sqldelightnoteapp.redux.State

data class NoteListState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false,
    val recentlyDeletedNote: Note? = null
) : State
