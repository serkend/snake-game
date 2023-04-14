package com.development.unique_snakegame.ui.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.development.unique_snakegame.ui.entities.Direction
import com.development.unique_snakegame.ui.states.GameState
import com.development.unique_snakegame.ui.utils.BOARD_SIZE
import com.development.unique_snakegame.ui.utils.SCORE_FOR_FOOD
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel : ViewModel() {
    private val _gameStateFlow =
        MutableStateFlow(
            GameState(
                food = Pair(5, 5),
                snake = listOf(Pair(7, 7)),
                direction = Direction.RIGHT,
                score = 0
            )
        )
    val gameStateFlow = _gameStateFlow.asStateFlow()

    private var job: Job? = null

    fun changeDirection(direction: Direction) {
        _gameStateFlow.value = _gameStateFlow.value.copy(direction = direction)
    }

    fun play() {
        if (job == null) {
            job = viewModelScope.launch(Dispatchers.Default) {
                var snakeLength = 4
                while (true) {
                    delay(150L)
                    _gameStateFlow.value.let {
                        val newPosition = Pair(
                            (it.snake.first().first + it.direction.offset.first + BOARD_SIZE) % BOARD_SIZE,
                            (it.snake.first().second + it.direction.offset.second + BOARD_SIZE) % BOARD_SIZE
                        )

                        if (newPosition == it.food) {
                            _gameStateFlow.value.score += SCORE_FOR_FOOD
                            Log.e("TAG", "play: ${_gameStateFlow.value.score}")
                            snakeLength++
                        }

                        if (it.snake.contains(newPosition)) {
                            snakeLength = 4
                            _gameStateFlow.value = it.copy(isCollided = true)
                        } else {
                            _gameStateFlow.value = it.copy(
                                food = (if (newPosition == it.food) Pair(
                                    Random.nextInt(BOARD_SIZE),
                                    Random.nextInt(BOARD_SIZE)
                                ) else it.food),
                                snake = listOf(newPosition) + it.snake.take(snakeLength - 1) // last element of snake removes
                            )
                        }
                    }
                }
            }
        }
    }

    fun resetGame() {
        _gameStateFlow.value = GameState(
            food = Pair(5, 5),
            snake = listOf(Pair(7, 7)),
            isCollided = false,
            direction = Direction.RIGHT,
            score = 0
        )
    }
}