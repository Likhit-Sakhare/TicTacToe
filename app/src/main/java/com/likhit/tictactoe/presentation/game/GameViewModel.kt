package com.likhit.tictactoe.presentation.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.likhit.tictactoe.presentation.game.utils.BoardCellValue
import com.likhit.tictactoe.presentation.game.utils.VictoryType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {

    var playerCircleCount by mutableStateOf(0)
        private set

    var playerCrossCount by mutableStateOf(0)
        private set

    var drawCount by mutableStateOf(0)
        private set

    var turnText by mutableStateOf("Player 'O' turn")
        private set

    var currentTurn by mutableStateOf(BoardCellValue.CIRCLE)
        private set

    var victoryType by mutableStateOf(VictoryType.NONE)
        private set

    var hasWon by mutableStateOf(false)
        private set

    var boardItems by mutableStateOf(
        mutableMapOf(
            1 to BoardCellValue.NONE,
            2 to BoardCellValue.NONE,
            3 to BoardCellValue.NONE,
            4 to BoardCellValue.NONE,
            5 to BoardCellValue.NONE,
            6 to BoardCellValue.NONE,
            7 to BoardCellValue.NONE,
            8 to BoardCellValue.NONE,
            9 to BoardCellValue.NONE
        )
    )

    fun onBoardTapped(cellNo: Int) {
        if (boardItems[cellNo] != BoardCellValue.NONE) {
            return
        }

        //Create a new instance and reassign it to trigger recomposition, if we wouldn't do this
        //then the recomposition doesn't happens
        val newBoardItems = boardItems.toMutableMap()
        newBoardItems[cellNo] = currentTurn
        boardItems = newBoardItems

        if (currentTurn == BoardCellValue.CIRCLE) {
            boardItems[cellNo] = BoardCellValue.CIRCLE
            if (checkForVictory(BoardCellValue.CIRCLE)) {
                turnText = "Player 'O' Won"
                playerCircleCount += 1
                currentTurn = BoardCellValue.NONE
                hasWon = true
            } else if (isBoardFull()) {
                turnText = "Game Draw"
                drawCount += 1
            } else {
                turnText = "Player 'X' turn"
                currentTurn = BoardCellValue.CROSS
            }
        } else if (currentTurn == BoardCellValue.CROSS) {
            boardItems[cellNo] = BoardCellValue.CROSS
            if (checkForVictory(BoardCellValue.CROSS)) {
                turnText = "Player 'X' Won"
                playerCrossCount += 1
                currentTurn = BoardCellValue.NONE
                hasWon = true
            } else if (isBoardFull()) {
                turnText = "Game Draw"
                drawCount += 1
            } else {
                turnText = "Player 'O' turn"
                currentTurn = BoardCellValue.CIRCLE
            }
        }
    }

    private fun checkForVictory(boardCellValue: BoardCellValue): Boolean {
        when {
            boardItems[1] == boardCellValue
                    && boardItems[2] == boardCellValue
                    && boardItems[3] == boardCellValue -> {
                victoryType = VictoryType.HORIZONTAL1
                return true
            }

            boardItems[4] == boardCellValue
                    && boardItems[5] == boardCellValue
                    && boardItems[6] == boardCellValue -> {
                victoryType = VictoryType.HORIZONTAL2
                return true
            }

            boardItems[7] == boardCellValue
                    && boardItems[8] == boardCellValue
                    && boardItems[9] == boardCellValue -> {
                victoryType = VictoryType.HORIZONTAL3
                return true
            }

            boardItems[1] == boardCellValue
                    && boardItems[4] == boardCellValue
                    && boardItems[7] == boardCellValue -> {
                victoryType = VictoryType.VERTICAL1
                return true
            }

            boardItems[2] == boardCellValue
                    && boardItems[5] == boardCellValue
                    && boardItems[8] == boardCellValue -> {
                victoryType = VictoryType.VERTICAL2
                return true
            }

            boardItems[3] == boardCellValue
                    && boardItems[6] == boardCellValue
                    && boardItems[9] == boardCellValue -> {
                victoryType = VictoryType.VERTICAL3
                return true
            }

            boardItems[1] == boardCellValue
                    && boardItems[5] == boardCellValue
                    && boardItems[9] == boardCellValue -> {
                victoryType = VictoryType.DIAGONAL1
                return true
            }

            boardItems[3] == boardCellValue
                    && boardItems[5] == boardCellValue
                    && boardItems[7] == boardCellValue -> {
                victoryType = VictoryType.DIAGONAL2
                return true
            }

            else -> return false
        }
    }

    private fun isBoardFull(): Boolean {
        if (boardItems.containsValue(BoardCellValue.NONE)) {
            return false
        } else {
            return true
        }
    }

    fun onPlayAgainButtonClicked() {
        boardItems = mutableMapOf(
            1 to BoardCellValue.NONE,
            2 to BoardCellValue.NONE,
            3 to BoardCellValue.NONE,
            4 to BoardCellValue.NONE,
            5 to BoardCellValue.NONE,
            6 to BoardCellValue.NONE,
            7 to BoardCellValue.NONE,
            8 to BoardCellValue.NONE,
            9 to BoardCellValue.NONE
        )
        turnText = "Player 'O' turn"
        currentTurn = BoardCellValue.CIRCLE
        victoryType = VictoryType.NONE
        hasWon = false
    }

    fun isPlayAgainButtonVisible(): Boolean {
        return isBoardFull() || checkForVictory(BoardCellValue.CROSS)
                || checkForVictory(BoardCellValue.CIRCLE)
    }
}