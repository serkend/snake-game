package com.development.unique_snakegame

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.development.unique_snakegame.ui.components.MyAlertDialog
import com.development.unique_snakegame.ui.states.GameState
import com.development.unique_snakegame.ui.theme.DarkGreen
import com.development.unique_snakegame.ui.theme.Shapes
import com.development.unique_snakegame.ui.theme.SnakeGameTheme
import com.development.unique_snakegame.ui.viewmodels.GameViewModel
import com.development.unique_snakegame.ui.entities.Direction
import com.development.unique_snakegame.ui.utils.BOARD_SIZE

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnakeGameTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: GameViewModel = viewModel()
                    val gameState = viewModel.gameStateFlow.collectAsState().value
                    GameContent(viewModel , gameState)
                }
            }
        }
    }
}

@Composable
fun GameContent(viewModel: GameViewModel,gameState:GameState) {
   // val gameState = viewModel.gameStateFlow.collectAsState()
    Log.e("TAG", "GameContent: ${gameState.score}")
    if (gameState.isCollided) {
        MyAlertDialog {
            viewModel.resetGame()
        }
    } else {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Board(gameState)
            Buttons(currDirection = gameState.direction, viewModel = viewModel) { direction ->
                viewModel.changeDirection(direction)
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = "Score : ${gameState.score}", style = MaterialTheme.typography.h2)
            }
        }
    }
}

@Composable
fun Buttons(
    currDirection: Direction,
    viewModel: GameViewModel,
    onDirectionalChange: (Direction) -> Unit
) {
    val buttonSize = Modifier.size(64.dp)

    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                if (currDirection != Direction.DOWN) onDirectionalChange(Direction.UP)
                viewModel.play()
            },
            modifier = buttonSize
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
        }
        Row {
            Button(
                onClick = {
                    if (currDirection != Direction.RIGHT) onDirectionalChange(Direction.LEFT)
                    viewModel.play()
                },
                modifier = buttonSize
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = null)
            }
            Spacer(modifier = buttonSize)
            Button(
                onClick = {
                    if (currDirection != Direction.LEFT) onDirectionalChange(Direction.RIGHT)
                    viewModel.play()
                },
                modifier = buttonSize
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }
        Button(
            onClick = {
                if (currDirection != Direction.UP) onDirectionalChange(Direction.DOWN)
                viewModel.play()
            },
            modifier = buttonSize
        ) {
            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
        }
    }
}

@Composable
fun Board(gameState: GameState) {
    BoxWithConstraints(modifier = Modifier.padding(16.dp)) {
        val tileSize = maxWidth / BOARD_SIZE

        Box(
            modifier = Modifier
                .size(maxWidth)
                .border(2.dp, DarkGreen)
        )
        Box(
            modifier = Modifier
                .offset(
                    x = tileSize * gameState.food.first,
                    y = tileSize * gameState.food.second
                )
                .size(tileSize)
                .background(DarkGreen, CircleShape)
        )
        gameState.snake.forEach {
            Box(
                modifier = Modifier
                    .offset(
                        x = tileSize * it.first,
                        y = tileSize * it.second
                    )
                    .size(tileSize)
                    .background(DarkGreen, Shapes.small)
            )
        }
    }
}