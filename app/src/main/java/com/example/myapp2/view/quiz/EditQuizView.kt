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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.myapp2.model.LocalQuizViewModel

@Composable
fun EditQuizView(modifier: Modifier = Modifier, quizId: Long) {
    val quizViewModel = LocalQuizViewModel.current

    LaunchedEffect(quizId) {
        quizViewModel.getQuizWithQuestsAndOptionsId(quizId)
    }
    val quizWithQuestsAndOptions by quizViewModel.getQuizWithQuestsAndOptions.collectAsState()

    var showAddQuestionSheet by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        quizWithQuestsAndOptions?.quests?.forEachIndexed { index, item ->
            QuestCardComponent(index = index, item = item)
        }

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
                showAddQuestionSheet = true
            }
        ) { Text(text = "Add New Question", modifier = Modifier.padding(vertical = 6.dp)) }
    }

    if(showAddQuestionSheet) {
        AddQuestSheet(quizId = quizId, showSheet = { showAddQuestionSheet = it })
    }
}