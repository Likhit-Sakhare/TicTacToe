package com.likhit.tictactoe.presentation.game.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import com.likhit.tictactoe.ui.theme.Aqua
import com.likhit.tictactoe.ui.theme.GreenishYellow

@Composable
fun CrossPiece() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        //First diagonal line of cross i.e. from top-left to bottom-right
        drawLine(
            color = Aqua,
            strokeWidth = 20f,
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

        //Second diagonal line of cross i.e. from top-right to bottom-left
        drawLine(
            color = Aqua,
            strokeWidth = 20f,
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

@Composable
fun CirclePiece() {
    Canvas(
        modifier = Modifier
            .size(60.dp)
            .padding(5.dp)
    ) {
        drawCircle(
            color = GreenishYellow,
            style = Stroke(width = 20f)
        )
    }
}