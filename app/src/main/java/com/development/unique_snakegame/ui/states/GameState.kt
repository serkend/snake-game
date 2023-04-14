package com.development.unique_snakegame.ui.states

import com.development.unique_snakegame.ui.entities.Direction

data class GameState(
    val food: Pair<Int, Int>,
    val snake: List<Pair<Int, Int>>,
    val isCollided: Boolean = false,
    val direction: Direction,
    var score:Int
)
