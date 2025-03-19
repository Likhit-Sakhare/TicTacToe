package com.likhit.tictactoe.presentation.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun GameBoardBase() {
    Canvas(
        modifier = Modifier
            .size(300.dp)
            .padding(10.dp)
    ) {
        //First vertical line
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 1/3,
                y = 0f
            ),
            end = Offset(
                x = size.width * 1/3,
                y = size.height
            )
        )

        //Second vertical line
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = size.width * 2/3,
                y = 0f
            ),
            end = Offset(
                x = size.width * 2/3,
                y = size.height
            )
        )

        //First horizontal line
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 1/3
            ),
            end = Offset(
                x = size.width,
                y = size.height * 1/3
            )
        )

        //Second horizontal line
        drawLine(
            color = Color.Gray,
            strokeWidth = 5f,
            cap = StrokeCap.Round,
            start = Offset(
                x = 0f,
                y = size.height * 2/3
            ),
            end = Offset(
                x = size.width,
                y = size.height * 2/3
            )
        )
    }
}