package com.example.sqldelightnoteapp.redux

interface Reducer<A: Action, S: State> {

    fun reduce(
        action: A,
        currentState: S,
    ): S
}