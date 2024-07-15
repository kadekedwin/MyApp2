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
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.entity.Quest
import com.example.myapp2.model.entity.QuestOption
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
    fun AddQuestionSheet(quizId: Long, showSheet: (Boolean) -> Unit) {
    val quizViewModel = LocalQuizViewModel.current

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()

    var inputQuestion by remember { mutableStateOf("") }
    var optionCount by remember { mutableStateOf(3) }
    val inputOptions = remember {
        List(optionCount) {
            mutableStateOf("")
        }
    }

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
                inputOptions.forEachIndexed { index, input ->
                    OutlinedTextField(
                        value = input.value,
                        onValueChange = { input.value = it },
                        label = { Text(text = "Option $index") },
                        placeholder = { Text(text = "Option $index") },
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
                    quizViewModel.insertQuest(Quest(quizId = quizId, question = inputQuestion), onRetreived = { questId ->
                        inputOptions.forEachIndexed { index, input ->
                            quizViewModel.insertQuestOption(QuestOption(questId = questId, option = input.value), onRetreived = {})
                        }
                    })

                    scope.launch { sheetState.hide() }.invokeOnCompletion {
                        if (!sheetState.isVisible) {
                            showSheet(false)
                        }
                    }
                }
            ) { Text(text = "Save", modifier = Modifier.padding(vertical = 6.dp)) }
        }
    }
}