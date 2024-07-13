package com.example.myapp2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapp2.ui.theme.MyApp2Theme
import com.example.myapp2.view.BottomBar
import com.example.myapp2.view.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var selectedBottomBarItem by remember { mutableIntStateOf(0) }

            MyApp2Theme {
                Scaffold(
                    bottomBar = { BottomBar(selectedItem = selectedBottomBarItem, onSelectedItemChanged = { selectedBottomBarItem = it }) }
                ) { innerPadding ->
                    when(selectedBottomBarItem) {
                        0 -> { HomeScreen(modifier = Modifier.padding(innerPadding)) }
                        1 -> {  }
                        2 -> {  }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var selectedBottomBarItem by remember { mutableIntStateOf(0) }

    MyApp2Theme {
        Scaffold(
            bottomBar = { BottomBar(selectedItem = selectedBottomBarItem, onSelectedItemChanged = { selectedBottomBarItem = it }) }
        ) { innerPadding ->
            when(selectedBottomBarItem) {
                0 -> { HomeScreen(modifier = Modifier.padding(innerPadding)) }
                1 -> {  }
                2 -> {  }
            }
        }
    }
}