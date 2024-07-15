package com.example.myapp2.view.quiz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddQuestionSheet(showSheet: (Boolean) -> Unit) {

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var optionCount by remember { mutableStateOf(3) }
    var inputQuestion by remember { mutableStateOf("") }
//    var inputOptions by remember { mutableStateOf(arrayOf()) }

    ModalBottomSheet(
        onDismissRequest = {
            showSheet(false)
        },
        sheetState = sheetState
    ) {
        Column(modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp)
            .padding(horizontal = 24.dp)
        ) {
            OutlinedTextField(
                value = inputQuestion,
                onValueChange = { inputQuestion = it },
                label = { Text(text = "Input Question") },
                placeholder = { Text(text = "How many panets on the solar system?") },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Column(
                modifier = Modifier.padding(top = 24.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (i in 0..optionCount) {
                    OutlinedTextField(
                        value = inputQuestion,
                        onValueChange = { inputQuestion = it },
                        label = { Text(text = "Option $i") },
                        placeholder = { Text(text = "Answer $i") },
                        shape = RoundedCornerShape(24.dp),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray
                ),
                onClick = { optionCount += 1 }
            ) { Text(text = "Add Option", modifier = Modifier.padding(vertical = 6.dp)) }

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

                }
            ) { Text(text = "Save", modifier = Modifier.padding(vertical = 6.dp)) }
        }
    }
}