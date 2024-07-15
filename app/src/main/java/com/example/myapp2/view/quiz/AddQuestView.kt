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
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapp2.R
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.entity.QuestOption
import com.example.myapp2.model.entity.Quiz
import com.example.myapp2.model.entity.QuizWithQuests

@Composable
fun AddQuestView(modifier: Modifier = Modifier, navController: NavController, quizId: Int) {
    val quizViewModel = LocalQuizViewModel.current

    var showAddQuestionSheet by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp)
            .padding(horizontal = 24.dp)
    ) {

        Surface(
            shape = RoundedCornerShape(24.dp),
            border = BorderStroke(width = 1.dp, color = Color.Gray.copy(alpha = 0.5f)),
            color = Color.White,
            modifier = modifier.fillMaxWidth(),
            onClick = {

            }
        ) {
            Column(
                modifier = Modifier.padding(vertical = 24.dp)
            ) {
                Text(text = "Test")
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
        AddQuestionSheet(showSheet = { showAddQuestionSheet = it })
    }
}