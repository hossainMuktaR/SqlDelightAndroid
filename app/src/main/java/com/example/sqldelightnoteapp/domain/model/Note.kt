package com.example.sqldelightnoteapp.domain.model

import com.example.sqldelightnoteapp.ui.theme.BabyBlue
import com.example.sqldelightnoteapp.ui.theme.LightGreen
import com.example.sqldelightnoteapp.ui.theme.RedOrange
import com.example.sqldelightnoteapp.ui.theme.RedPink
import com.example.sqldelightnoteapp.ui.theme.Violet

data class Note(
    val title: String,
    val content: String,
    val timeStamp: Long,
    val color: Int,
    val id: Long? = null
){
    companion object {
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink )
    }
}

class InvalidNoteException( message: String): Exception(message)
