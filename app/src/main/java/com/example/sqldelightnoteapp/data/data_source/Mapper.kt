package com.example.sqldelightnoteapp.data.data_source

import com.example.sqldelightnoteapp.NoteEntity
import com.example.sqldelightnoteapp.domain.model.Note

fun NoteEntity.toNote(): Note {
    return Note(
        id = id,
        title = title,
        timeStamp = timeStamp,
        content = content,
        color = color.toInt(),
    )
}

