package com.development.unique_snakegame.ui.entities

enum class Direction(val offset:Pair<Int,Int>) {
    RIGHT(Pair(1,0)),
    LEFT(Pair(-1,0)),
    UP(Pair(0,-1)),
    DOWN(Pair(0,1))
}