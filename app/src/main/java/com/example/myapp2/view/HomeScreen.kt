package com.example.myapp2.view

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp2.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val name = "Edwin"
    val header = "Lorem ipsum dolor sit consectetur."

    Column(
        modifier = modifier
//            .background(Color.White)
            .verticalScroll(rememberScrollState())
            .padding(vertical = 24.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(text = "Hello, $name")
            Text(
                text = header,
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                lineHeight = 40.sp,
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }

        Row(
            modifier = Modifier
                .horizontalScroll(rememberScrollState())
                .padding(vertical = 32.dp)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            QuizCardComponent(title = "Moon based dump", questionCount = 19, progress = 0.3f, icon = R.drawable.stationery, color = Color(0xffffa500))
            QuizCardComponent(title = "The world Biological", questionCount = 19, progress = 0.5f, icon = R.drawable.stationery, color = Color.Blue)
        }

        Column(modifier = Modifier.padding(horizontal = 24.dp)) {
            Text(
                text = "Recent Goals",
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 20.dp)
            )
            Column(modifier = Modifier, verticalArrangement = Arrangement.spacedBy(10.dp)) {
                QuizListComponent(
                    title = "Test list quiz",
                    questionCount = 21,
                    progress = 0.2f,
                    icon = R.drawable.disc,
                    color = Color(0xff6f2da8)
                )
                QuizListComponent(
                    title = "Test list quiz",
                    questionCount = 21,
                    progress = 0.7f,
                    icon = R.drawable.disc,
                    color = Color(0xff6f2da8)
                )
                QuizListComponent(
                    title = "Test list quiz",
                    questionCount = 21,
                    progress = 0.4f,
                    icon = R.drawable.disc,
                    color = Color(0xff6f2da8)
                )

            }
        }
    }
}