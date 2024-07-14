package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp2.model.LocalQuizViewModel

@Composable
fun QuizScreenNavigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "quizScreen") {
        composable("quizScreen") { QuizScreen(modifier = modifier, navController = navController) }
        composable("addQuizView") { AddQuizView(modifier = modifier, navController = navController) }
    }
}


@Composable
fun QuizScreen(modifier: Modifier = Modifier, navController: NavController) {
    val quizViewModel = LocalQuizViewModel.current

    val quizChunked = quizViewModel.allQuiz.collectAsState().value.chunked(2)

    Column(
        modifier = modifier.padding(horizontal = 24.dp).padding(vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(24.dp),
            color = Color.Gray.copy(alpha = 0.1f),
            border = BorderStroke(1.dp, color = Color.Gray.copy(alpha = 0.5f)),
            onClick = { navController.navigate(route = "addQuizView") }
        ) {
            Icon(Icons.Rounded.Add, contentDescription = null, modifier = Modifier.padding(vertical = 24.dp))
        }

        Text(
            text = "Your Quiz",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
            quizChunked.forEach {
                Row(modifier = Modifier, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    it.forEach {
                        QuizEditCardComponent(title = it.title, questionCount = 10, icon = it.icon, color = Color.Blue, modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}