package com.developbharat.developbharat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.modules.chat.core.ChatScreens
import com.developbharat.developbharat.modules.chat.screens.home.ChatHomeScreen
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DevelopBharatTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = ChatScreens.ChatHomeScreen) {
                    // chat screens
                    composable<ChatScreens.ChatHomeScreen> { ChatHomeScreen(navController) }
                }
            }
        }
    }
}