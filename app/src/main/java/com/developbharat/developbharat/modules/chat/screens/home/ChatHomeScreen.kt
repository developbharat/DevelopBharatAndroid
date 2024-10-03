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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.modules.chat.screens.home.components.ChatTab
import com.developbharat.developbharat.modules.chat.screens.home.components.ChatTabs
import com.developbharat.developbharat.modules.chat.screens.home.components.ContactsTabContent
import com.developbharat.developbharat.modules.common.components.SmallTopBar
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatHomeScreen(navController: NavController, viewModel: ChatHomeViewModel = hiltViewModel()) {

    var state by remember { mutableStateOf(0) }


    Scaffold(topBar = {
        SmallTopBar(
            title = "Chats",
            subtitle = "Loading...",
            actions = {
                IconButton(onClick = {}) { Icon(Icons.Outlined.Search, contentDescription = "Search") }
                IconButton(onClick = {}) { Icon(Icons.Outlined.MoreVert, contentDescription = "More") }
            })
    }) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            ChatTabs(defaultSelectedTab = 0) { selectedTab ->
                when (selectedTab) {
                    is ChatTab.Contacts -> {
                        ContactsTabContent()
                    }

                    is ChatTab.Groups -> {
                        Text("Groups")
                    }

                    is ChatTab.Bots -> {
                        Text("Groups")
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