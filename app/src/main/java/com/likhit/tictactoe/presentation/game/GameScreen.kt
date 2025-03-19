package com.likhit.tictactoe.presentation.game

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.likhit.tictactoe.R
import com.likhit.tictactoe.presentation.game.components.CirclePiece
import com.likhit.tictactoe.presentation.game.components.CrossPiece
import com.likhit.tictactoe.presentation.game.components.DrawVictoryLine
import com.likhit.tictactoe.presentation.game.components.GameBoardBase
import com.likhit.tictactoe.presentation.game.utils.BoardCellValue
import com.likhit.tictactoe.ui.theme.CustomBlue
import com.likhit.tictactoe.ui.theme.GrayBackground
import com.likhit.tictactoe.ui.theme.GreenishYellow

@Composable
fun GameScreen(
    modifier: Modifier = Modifier,
    viewModel: GameViewModel = hiltViewModel()
) {
    val playerCircleCount = viewModel.playerCircleCount
    val playerCrossCount = viewModel.playerCrossCount
    val drawCount = viewModel.drawCount
    val turnText = viewModel.turnText
    val victoryType = viewModel.victoryType
    val hasWon = viewModel.hasWon

    var showDialog by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(GrayBackground)
            .padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .border(
                        width = 1.5.dp,
                        color = Color.Black.copy(alpha = 0.5f),
                        RoundedCornerShape(8.dp)
                    )
                    .shadow(
                        elevation = 16.dp,
                        shape = RoundedCornerShape(8.dp)
                    )
            ){
                IconButton(
                    onClick = {
                        showDialog = !showDialog
                    }
                ) {
                    Image(
                        painter = painterResource(R.drawable.score),
                        contentDescription = "Score Card"
                    )
                }
            }


        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Tic Tac Toe",
            fontSize = 50.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(
                Font(R.font.dancing_script_regular)
            ),
            color = CustomBlue,
            modifier = Modifier
                .padding(vertical = 16.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
                .shadow(
                    elevation = 12.dp,
                    shape = RoundedCornerShape(24.dp)
                )
                .clip(RoundedCornerShape(24.dp))
                .background(GrayBackground),
            contentAlignment = Alignment.Center
        ){
            GameBoardBase()
            LazyVerticalGrid(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .aspectRatio(1f),
                columns = GridCells.Fixed(3)
            ) {
                viewModel.boardItems.forEach { (cellNo, boardCellValue) ->
                    item {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .aspectRatio(1f)
                                .clickable(
                                    interactionSource = MutableInteractionSource(),
                                    indication = null
                                ) {
                                    viewModel.onBoardTapped(cellNo)
                                },
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            AnimatedVisibility(
                                visible = viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                                enter = scaleIn(tween(1000))
                            ) {
                                when (boardCellValue) {
                                    BoardCellValue.CIRCLE -> {
                                        CirclePiece()
                                    }
                                    BoardCellValue.CROSS -> {
                                        CrossPiece()
                                    }
                                    else -> {}
                                }
                            }
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                AnimatedVisibility(
                    visible = hasWon,
                    enter = fadeIn(
                        tween(2000)
                    )
                ){
                    DrawVictoryLine(victoryType)
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = turnText,
                fontSize = 24.sp,
                color = Color.Black,
                fontFamily = FontFamily(
                    Font(R.font.dancing_script_regular)
                ),
                fontWeight = FontWeight.Bold
            )
            Row(
                modifier = Modifier.size(140.dp, 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                AnimatedVisibility(
                    visible = viewModel.isPlayAgainButtonVisible(),
                    enter = fadeIn(animationSpec = tween(500)) + scaleIn(animationSpec = tween(500)),
                    exit = fadeOut(animationSpec = tween(300)) + scaleOut(animationSpec = tween(300))
                ) {
                    Button(
                        onClick = {
                            viewModel.onPlayAgainButtonClicked()
                        },
                        shape = RoundedCornerShape(8.dp),
                        elevation = ButtonDefaults.buttonElevation(
                            defaultElevation = 8.dp
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = CustomBlue,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Play Again",
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }

    if(showDialog){
        Dialog(
            onDismissRequest = {
                showDialog = false
            }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(20.dp),
                contentAlignment = Alignment.Center
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Player O: $playerCircleCount",
                        fontSize = 24.sp,
                        color = GreenishYellow,
                        fontFamily = FontFamily(
                            Font(R.font.dancing_script_regular, FontWeight.Bold)
                        )
                    )
                    Text(
                        text = "Draw: $drawCount",
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(R.font.dancing_script_regular, FontWeight.Bold)
                        )
                    )
                    Text(
                        text = "Player X: $playerCrossCount",
                        fontSize = 24.sp,
                        color = CustomBlue,
                        fontFamily = FontFamily(
                            Font(R.font.dancing_script_regular, FontWeight.Bold)
                        )
                    )
                }
            }
        }
    }
}