package com.example.composecamp.Unit8_SplashScreenWithCompose

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by Dilara Kiraz on 11.09.2024.
 */
@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    currentRoute: String,
    onItemClick: (BottomNavItem) -> Unit
) {
    BottomAppBar {
        BottomNavigation(
            backgroundColor = Color.White
        ) {
            items.forEach { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(imageVector = item.icon, contentDescription = item.title)
                    },
                    label = { Text(text = item.title) },
                    selected = currentRoute == item.route,
                    onClick = { onItemClick(item) }
                )
            }
        }
    }
}