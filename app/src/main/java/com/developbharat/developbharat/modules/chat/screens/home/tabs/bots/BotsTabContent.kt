package com.developbharat.developbharat.modules.chat.screens.home.tabs.bots

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.modules.chat.core.ChatContent
import com.developbharat.developbharat.modules.chat.screens.home.components.ChatListItem
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime

@Composable
fun BotsTabContent(navController: NavController, viewModel: BotsTabViewModel = hiltViewModel()) {
    // Chat items
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // unread message
        item {
            ChatListItem(
                avatar = null,
                name = "Super Resolution Bot",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                unreadChatsCount = 20,
                onClick = {}
            )
        }

        // read message
        item {
            ChatListItem(
                avatar = null,
                name = "OTP Text Bot",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun BotsTabContentPreview() {
    DevelopBharatTheme {
        BotsTabContent(navController = rememberNavController())
    }
}