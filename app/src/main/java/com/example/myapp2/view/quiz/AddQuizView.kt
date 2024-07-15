package com.example.myapp2.view.quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp2.R
import com.example.myapp2.model.LocalQuizViewModel
import com.example.myapp2.model.entity.Quiz

@Composable
fun AddQuizView(modifier: Modifier = Modifier, navController: NavController) {
    val quizViewModel = LocalQuizViewModel.current

    var inputTitle by remember { mutableStateOf("") }

    Column(modifier = modifier.padding(vertical = 24.dp).padding(horizontal = 24.dp)) {
        Box(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp)) {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.AutoMirrored.Rounded.KeyboardArrowLeft, contentDescription = null, modifier = Modifier.align(Alignment.TopStart))
            }
            Text(
                text = "Recent Goals",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth().padding(top = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.stationery),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .border(2.dp, Color.Black.copy(alpha = 0.5f), CircleShape)
                    .align(Alignment.Center)
                    .size(100.dp)
            )
        }

        Column(
            modifier = Modifier.padding(top = 24.dp).fillMaxWidth()
        ) {
            OutlinedTextField(
                value = inputTitle,
                onValueChange = { inputTitle = it },
                label = { Text(text = "Quiz Title") },
                placeholder = { Text(text = "Science flashback") },
                shape = RoundedCornerShape(24.dp),
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                shape = RoundedCornerShape(24.dp),
                colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.Black,
                    disabledContentColor = Color.White,
                    disabledContainerColor = Color.Gray
                ),
                onClick = {
                    quizViewModel.insertQuiz(Quiz(title = inputTitle, icon = R.drawable.stationery))
                    navController.navigate("quizScreen")
                }
            ) { Text(text = "New Quiz", modifier = Modifier.padding(vertical = 6.dp)) }
        }
    }
}