package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp2.R
import com.example.myapp2.model.LocalNavController
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.utils.argbToHex
import com.github.skydoves.colorpicker.compose.ColorEnvelope
import com.github.skydoves.colorpicker.compose.HsvColorPicker
import com.github.skydoves.colorpicker.compose.rememberColorPickerController

@Composable
fun AddQuizView(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    val quizViewModel = LocalQuizViewModel.current

    var showColorPicker by remember { mutableStateOf(false) }

    var inputTitle by remember { mutableStateOf("") }
    var inputColor by remember { mutableStateOf(Color.Blue.toArgb()) }

    val colorPickerController = rememberColorPickerController()


    Column(
        modifier = modifier
            .padding(vertical = 24.dp)
            .padding(horizontal = 24.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .align(alignment = Alignment.Center),
                shape = RoundedCornerShape(50),
                border = BorderStroke(2.dp, Color.Black.copy(alpha = 0.5f)),
                color = Color(inputColor).copy(alpha = 0.15f)

            ) {
                Image(
                    painter = painterResource(id = R.drawable.stationery),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(20.dp)
                )
            }
        }

        if(showColorPicker) {
            AlertDialog(
                onDismissRequest = { showColorPicker = false },
                confirmButton = {
//                    TextButton(onClick = {
//                        showColorPicker = false
//                    }) {
//                        Text(
//                            text = "Cancel",
//                            fontSize = 20.sp,
//                            fontWeight = FontWeight.Medium
//                        )
//                    }

                    TextButton(onClick = {
                        showColorPicker = false
                    }) {
                        Text(
                            text = "Done",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                },
                text = {
                    HsvColorPicker(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(300.dp),
                        controller = colorPickerController,
                        onColorChanged = { colorEnvelope: ColorEnvelope ->
                            inputColor = colorEnvelope.color.toArgb()
                        }
                    )
                }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(60.dp),
                color = Color(inputColor),
                shape = RoundedCornerShape(50),
                onClick = {
                    showColorPicker = true
                }
            ){
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(3.dp),
                    color = Color(inputColor),
                    shape = RoundedCornerShape(50),
                    border = BorderStroke(4.dp, Color.White),
                ){}
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    modifier = Modifier
                        .width(150.dp)
                        .height(60.dp),
//                color = Color(inputColor),
                    shape = RoundedCornerShape(16.dp),
                    border = BorderStroke(2.dp, Color.Gray.copy(alpha = 0.5f)),
                    onClick = {
                        showColorPicker = true
                    }
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = argbToHex(inputColor),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }

                Text(
                    text = "HEX",
                    fontSize = 20.sp,
                    color = Color.Gray.copy(alpha = 0.5f)
                )
            }
        }


        OutlinedTextField(
            value = inputTitle,
            onValueChange = { inputTitle = it },
            label = { Text(text = "Quiz Title") },
            placeholder = { Text(text = "Science flashback") },
            shape = RoundedCornerShape(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            shape = RoundedCornerShape(24.dp),
            colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.Gray
            ),
            onClick = {
                quizViewModel.insertQuiz(Quiz(title = inputTitle, icon = R.drawable.stationery, color = inputColor), onRetreived = {})
                navController.navigate("quizScreen")
            }
        ) { Text(text = "New Quiz", modifier = Modifier.padding(vertical = 6.dp)) }
    }
}