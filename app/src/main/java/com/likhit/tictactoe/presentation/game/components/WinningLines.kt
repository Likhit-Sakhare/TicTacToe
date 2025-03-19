package com.likhit.tictactoe.presentation.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalWinningLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/6
            ),
            end = Offset(
                x = size.width,
                y = size.height * 1/6
            )
        )
    }
}

@Composable
fun HorizontalWinningLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/2
            ),
            end = Offset(
                x = size.width,
                y = size.height * 1/2
            )
        )
    }
}

@Composable
fun HorizontalWinningLine3() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 5/6
            ),
            end = Offset(
                x = size.width,
                y = size.height * 5/6
            )
        )
    }
}

@Composable
fun VerticalWinningLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/6,
                y = 0f
            ),
            end = Offset(
                x = size.width * 1/6,
                y = size.height
            )
        )
    }
}

@Composable
fun VerticalWinningLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/2,
                y = 0f
            ),
            end = Offset(
                x = size.width * 1/2,
                y = size.height
            )
        )
    }
}

@Composable
fun VerticalWinningLine3() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 5/6,
                y = 0f
            ),
            end = Offset(
                x = size.width * 5/6,
                y = size.height
            )
        )
    }
}

@Composable
fun DiagonalWinningLine1() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = 0f
            ),
            end = Offset(
                x = size.width,
                y = size.height
            )
        )
    }
}

@Composable
fun DiagonalWinningLine2() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height
            ),
            end = Offset(
                x = size.width,
                y = 0f
            )
        )
    }
}