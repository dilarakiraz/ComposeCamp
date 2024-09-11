package com.example.composecamp.Unit8_SplashScreenWithCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

class MainActivity8 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Composable
fun MainScreen() {
    val navController = rememberNavController() // NavController'ı oluşturun

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(BottomNavItem.Home, BottomNavItem.Profile, BottomNavItem.Settings),
                currentRoute = navController.currentBackStackEntry?.destination?.route ?: "",
                onItemClick = { item ->
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        } ) { innerPadding ->
        NavigationHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding) // Padding değerlerini burada uygulayın
        )
    }
}
