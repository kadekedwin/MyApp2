package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.myapp2.model.LocalNavController
import com.example.myapp2.model.LocalQuizViewModel

@Composable
fun QuizScreen(modifier: Modifier = Modifier) {
    val navController = LocalNavController.current
    val quizViewModel = LocalQuizViewModel.current

    val allQuiz by quizViewModel.allQuiz.collectAsStateWithLifecycle()
    val allQuizChunked = allQuiz.chunked(2)

    Column(
        modifier = modifier
            .padding(horizontal = 24.dp)
            .padding(vertical = 24.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = Color.Gray.copy(alpha = 0.1f),
            border = BorderStroke(1.dp, color = Color.Gray.copy(alpha = 0.5f)),
            onClick = { navController.navigate("addQuizView") }
        ) {
            Icon(Icons.Rounded.Add, contentDescription = null, modifier = Modifier.padding(vertical = 24.dp))
        }

        Text(
            text = "Your Quiz",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top = 16.dp).padding()
        )

        Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            allQuizChunked.forEach {
                Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    it.forEach {
                        QuizEditCardComponent(it, modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}