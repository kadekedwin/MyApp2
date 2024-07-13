package com.example.myapp2.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val name = "Edwin"
    val header = "Lorem ipsum dolor sit amet, consectetur."

    Column(
        modifier = modifier
            .background(Color.White)
            .padding(horizontal = 24.dp)
            .padding(top = 24.dp)
    ) {
        Text(text = "Hello, $name")
        Text(
            text = header,
            fontWeight = FontWeight.Medium,
            fontSize = 32.sp,
            lineHeight = 40.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}