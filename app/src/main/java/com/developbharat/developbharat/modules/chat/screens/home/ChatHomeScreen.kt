package com.developbharat.developbharat.modules.chat.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.modules.chat.screens.home.components.BotsTabContent
import com.developbharat.developbharat.modules.chat.screens.home.components.ContactsTabContent
import com.developbharat.developbharat.modules.chat.screens.home.components.GroupsTabContent
import com.developbharat.developbharat.modules.common.components.SmallTopBar
import com.developbharat.developbharat.modules.common.components.Tabs
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.util.Timer
import kotlin.concurrent.schedule

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatHomeScreen(navController: NavController, viewModel: ChatHomeViewModel = hiltViewModel()) {
    val state = viewModel.state.value;


    // TODO: Remove and replace with actual logic Just to simulate tab updates
    LaunchedEffect(Unit) {
        Timer().schedule(2000) {
            viewModel.updateChatsCounts()
        }
    }


    Scaffold(topBar = {
        SmallTopBar(title = "Chats", subtitle = "Loading...", actions = {
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.Search, contentDescription = "Search"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    Icons.Outlined.MoreVert, contentDescription = "More"
                )
            }
        })
    }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            Tabs(initialSelectedTab = 0, tabs = state.tabs) { selectedTab ->
                when (selectedTab) {
                    is ChatTabs.Contacts -> {
                        ContactsTabContent()
                    }

                    is ChatTabs.Groups -> {
                        GroupsTabContent()
                    }

                    is ChatTabs.Bots -> {
                        BotsTabContent()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ChatHomeScreenPreview() {
    DevelopBharatTheme {
        ChatHomeScreen(navController = rememberNavController())
    }
}