package com.example.myapp2.view.quiz

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp2.model.LocalQuestViewModel
import com.example.myapp2.model.entity.Quest

@Composable
fun QuestCardComponent(index: Int, item: Quest) {
    val questViewModel = LocalQuestViewModel.current

    LaunchedEffect(item.id) {
        questViewModel.getQuestWithOptionsId(item.id)
    }

    val questWithOptions by questViewModel.getQuestWithOptions.collectAsState()

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
            HorizontalDivider(modifier = Modifier.padding(vertical = 10.dp))

            questWithOptions?.options?.forEachIndexed { index, item ->
                Text(text = "${index+1}. ${item.option}")
            }
        }
    }
}