package com.example.composecamp.Unit8_SplashScreenWithCompose

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings

/**
 * Created by Dilara Kiraz on 11.09.2024.
 */
sealed class BottomNavItem (val title: String, val icon: ImageVector, val route: String){
    object Home : BottomNavItem("Home", Icons.Filled.Home, "home")
    object Profile : BottomNavItem("Profile", Icons.Filled.Person, "profile")
    object Settings : BottomNavItem("Settings", Icons.Filled.Settings, "settings")
}