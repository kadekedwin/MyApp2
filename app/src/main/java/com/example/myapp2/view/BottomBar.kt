package com.example.myapp2.view

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.myapp2.R
import com.example.myapp2.model.LocalNavController

data class BottomBarItem(
    val title: String,
    val icon: Int,
    val route: String
)

val bottomBarItems = arrayOf(
    BottomBarItem("Home", icon = R.drawable.house_icon, "homeScreen"),
    BottomBarItem("Quiz", icon = R.drawable.grid_icon, "quizScreen"),
    BottomBarItem("Notifications", icon = R.drawable.bell_icon, "notificationScreen"),
    BottomBarItem("Settings", icon = R.drawable.gear_icon, "settingScreen")
)

@Composable
fun BottomBar() {
    val navController = LocalNavController.current
    var selectedItem by remember { mutableIntStateOf(0) }

    NavigationBar(
        containerColor = Color.White
    ) {
        bottomBarItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = ImageVector.vectorResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(24.dp)) },
//                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = {
                    selectedItem = index
                    navController.navigate(item.route)
                },
                colors = NavigationBarItemColors(
                    selectedIconColor = Color.Black,
                    selectedTextColor = Color.Black,
                    selectedIndicatorColor = Color.Transparent,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray,
                    disabledIconColor = Color.Gray,
                    disabledTextColor = Color.Gray
                )
            )
        }
    }
}
