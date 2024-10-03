package com.developbharat.developbharat.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text("Jai Hind!")
            }
        }
    }
}