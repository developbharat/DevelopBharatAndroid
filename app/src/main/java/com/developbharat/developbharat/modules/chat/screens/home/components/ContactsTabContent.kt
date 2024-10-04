package com.developbharat.developbharat.modules.chat.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.common.ChatContent
import com.developbharat.developbharat.modules.chat.core.ChatScreens
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime

@Composable
fun ContactsTabContent(navController: NavController) {
    // Chat items
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // unread message
        item {
            ChatListItem(
                avatar = null,
                name = "Shubendu CDIS IIT Stock Market Chandigarh",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                unreadChatsCount = 20,
                onClick = {
                    // TODO: replace with actual navigation with data.
                    navController.navigate(ChatScreens.ChatCommunicateScreen)
                }
            )
        }

        // read message
        item {
            ChatListItem(
                avatar = null,
                name = "Shubendu CDIS IIT Stock Market Chandigarh",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                onClick = {}
            )
        }

        // unsaved contact message
        item {
            ChatListItem(
                avatar = null,
                name = "+91 701 510 8956",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun ContactsTabContentPreview() {
    DevelopBharatTheme {
        ContactsTabContent(navController = rememberNavController())
    }
}