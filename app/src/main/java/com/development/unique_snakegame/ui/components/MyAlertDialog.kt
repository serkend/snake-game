package com.development.unique_snakegame.ui.components

import androidx.compose.foundation.layout.*
import com.development.unique_snakegame.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.development.unique_snakegame.ui.theme.DarkGreen

@Composable
fun MyAlertDialog(
    onDismissDialog: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier.clip(shape = RoundedCornerShape(20.dp)),
        onDismissRequest = { onDismissDialog() },
        backgroundColor = DarkGreen,
        buttons = {
            Row(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .clip(shape = RoundedCornerShape(20.dp)),
                    onClick = { onDismissDialog() },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.Black,
                        contentColor = Color.White
                    )
                ) {
                    Text(stringResource(R.string.play_again), fontSize = 20.sp)
                }
            }
        },
        title = { Text(text = stringResource(id = R.string.empty)) },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = stringResource(R.string.fail), fontSize = 24.sp, color = Color.White)
            }
        }
    )
}