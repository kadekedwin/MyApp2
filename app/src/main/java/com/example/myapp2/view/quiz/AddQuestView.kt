package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp2.R
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.entity.QuestOption
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests

@Composable
fun AddQuestView(modifier: Modifier = Modifier, navController: NavController, quizId: Long) {
    val quizViewModel = LocalQuizViewModel.current

    val quizWithQuests by quizViewModel.quizWithQuests.collectAsState()
    val allQuest by quizViewModel.allQuestOption.collectAsState()

    LaunchedEffect(quizId) {
        quizViewModel.getQuizWithQuests(quizId)
    }

    var showAddQuestionSheet by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp)
            .padding(horizontal = 24.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        quizWithQuests?.quests?.forEachIndexed { index, item ->
            Surface(
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(width = 1.dp, color = Color.Gray.copy(alpha = 0.5f)),
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                onClick = {

                }
            ) {
                Column(
                    modifier = Modifier.padding(24.dp)
                ) {
                    Text(text = "Quest ${index+1}")
                    Text(
                        text = item.question,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                    )
                    HorizontalDivider(modifier = Modifier.padding(10.dp))
                    Text(text = "option")
                }
            }
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
        AddQuestionSheet(quizId = quizId, showSheet = { showAddQuestionSheet = it })
    }
}