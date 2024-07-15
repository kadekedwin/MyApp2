package com.example.myapp2.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapp2.model.LocalNavController

@Composable
fun TopBarComponent() {
    val navController = LocalNavController.current

    Box(modifier = Modifier.fillMaxWidth()) {
        IconButton(modifier = Modifier.align(Alignment.CenterStart), onClick = { navController.popBackStack() }) {
            Icon(Icons.AutoMirrored.Rounded.KeyboardArrowLeft, contentDescription = null)
        }
        Text(
            text = "Recent Goals",
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}