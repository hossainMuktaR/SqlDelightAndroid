package com.example.sqldelightnoteapp.presentation.add_edit_note

import androidx.compose.ui.graphics.toArgb
import com.example.sqldelightnoteapp.domain.model.Note
import com.example.sqldelightnoteapp.redux.State

data class AddEditNoteState(
    val noteTitle: String = "",
    val titleHint: String = "Enter title here...",
    val isTitleHintVisible: Boolean = true,
    val noteContent: String = "",
    val contentHint: String = "Enter Note Content Here.....",
    val isContentHintVisible: Boolean = true,
    val noteColor: Int = Note.noteColors.random().toArgb(),
    val errorMessage: String? = null,
    val currentNoteid: Int? = null,
): State
