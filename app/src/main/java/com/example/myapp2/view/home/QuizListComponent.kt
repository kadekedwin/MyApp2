package com.example.myapp2.view.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp2.R

@Composable
fun QuizListComponent(title: String, questionCount: Int, progress: Float, icon: Int, color: Color) {
    Surface(
        shape = RoundedCornerShape(24.dp),
        color = color.copy(alpha = 0.15f),
        modifier = Modifier
            .fillMaxWidth(),
        onClick = {

        }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Surface(
                modifier = Modifier
                    .size(50.dp),
                shape = RoundedCornerShape(50),
                color = color

            ) {
                Image(
                    painter = painterResource(
                        id = icon,
                    ),
                    contentDescription = null,
                    modifier = Modifier.padding(6.dp)
                )
            }

            Column(
                modifier = Modifier.fillMaxWidth(0.7f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(text = title, maxLines = 1, overflow = TextOverflow.Ellipsis, fontSize = 20.sp, fontWeight = FontWeight.Medium)
                Text(text = "$questionCount Question")
            }

            Box(

            ) {
                Text(
                    text = "${(progress*100).toInt()}%",
                    color = color,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
                CircularProgressIndicator(
                    progress = { progress },
                    trackColor = color.copy(alpha = 0.15f),
                    color = color,
                    strokeWidth = 6.dp,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier.size(50.dp)
                )
            }

        }
    }
}

@Preview
@Composable
fun QuizListComponentPreview() {
    QuizListComponent(title = "Science for kids", questionCount = 12, progress = 0.5f, icon = R.drawable.disc ,color = Color.Cyan)
}