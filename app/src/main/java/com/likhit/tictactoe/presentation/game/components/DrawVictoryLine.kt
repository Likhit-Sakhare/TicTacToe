package com.likhit.tictactoe.presentation.game.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.likhit.tictactoe.presentation.game.utils.VictoryType

@Composable
fun DrawVictoryLine(
    victoryType: VictoryType
) {
    when(victoryType){
        VictoryType.HORIZONTAL1 -> HorizontalWinningLine1()
        VictoryType.HORIZONTAL2 -> HorizontalWinningLine2()
        VictoryType.HORIZONTAL3 -> HorizontalWinningLine3()
        VictoryType.VERTICAL1 -> VerticalWinningLine1()
        VictoryType.VERTICAL2 -> VerticalWinningLine2()
        VictoryType.VERTICAL3 -> VerticalWinningLine3()
        VictoryType.DIAGONAL1 -> DiagonalWinningLine1()
        VictoryType.DIAGONAL2 -> DiagonalWinningLine2()
        else -> Unit
    }
}