package com.example.composecamp.Unit10_NavigationDrawer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.composecamp.Unit10_NavigationDrawer.ui.theme.ComposeCampTheme
import kotlinx.coroutines.launch

class MainActivity10 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCampTheme {
                NavigationDrawer()
            }
        }
    }


    @Composable
    fun NavigationDrawer() {
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val coroutineScope = rememberCoroutineScope()

        ModalDrawer(
            drawerState = drawerState,
            drawerContent = {
                DrawerContent()
            }
        ) {
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
                Text(text = "Main Content", style = MaterialTheme.typography.headlineMedium)
                Button(onClick = {
                    coroutineScope.launch {
                        if (drawerState.isOpen) {
                            drawerState.close()
                        } else {
                            drawerState.open()
                        }
                    }
                }) {
                    Text(text = "Toggle Drawer")
                }
            }
        }
    }

    @Composable
    fun DrawerContent() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = "Home", modifier = Modifier.clickable {
                // Burada Home'a tıklandığında yapılacak işlemleri tanımlayabilirsiniz
            }, style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Settings", modifier = Modifier.clickable {
                // Burada Settings'e tıklandığında yapılacak işlemleri tanımlayabilirsiniz
            }, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

