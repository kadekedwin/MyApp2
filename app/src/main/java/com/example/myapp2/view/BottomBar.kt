package com.example.myapp2.view

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.example.myapp2.R

data class BottomBarItem(
    val title: String,
    val icon: Int
)

val bottomBarItems = arrayOf(
    BottomBarItem("Home", icon = R.drawable.house_icon),
    BottomBarItem("Notifications", icon = R.drawable.bell_icon),
    BottomBarItem("Settings", icon = R.drawable.gear_icon)
)

@Composable
fun BottomBar(selectedItem: Int, onSelectedItemChanged: (Int) -> Unit) {

    NavigationBar(
        containerColor = Color.Transparent,
    ) {
        bottomBarItems.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(imageVector = ImageVector.vectorResource(id = item.icon), contentDescription = item.title, modifier = Modifier.size(24.dp)) },
//                label = { Text(item.title) },
                selected = selectedItem == index,
                onClick = { onSelectedItemChanged(index) },
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
