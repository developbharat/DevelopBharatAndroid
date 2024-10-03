package com.developbharat.developbharat.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.common.Screens
import com.developbharat.developbharat.ui.screens.home.HomeScreen
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
                NavHost(navController = navController, startDestination = Screens.HomeScreen) {
                    composable<Screens.HomeScreen> { HomeScreen(navController) }
                }
            }
        }
    }
}