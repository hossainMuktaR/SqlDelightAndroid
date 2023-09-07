package com.example.sqldelightnoteapp.redux

import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

interface Container<A: Action, S: State, SE: SideEffect> {

    val state: StateFlow<S>
    val sideEffect: SharedFlow<SE>

    suspend fun dispatch(action: A)

    suspend fun emitSideEffect(sideEffect: SE)
}