package com.developbharat.developbharat.modules.chat.screens.home.tabs.gropus

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
fun GroupsTabContent(navController: NavController, viewModel: GroupsTabViewModel = hiltViewModel()) {
    // Chat items
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // unread message
        item {
            ChatListItem(
                avatar = null,
                name = "Workshop on Sneak Peak into Therapy Room",
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
                name = "Group B- Sign Language Classes",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                onClick = {}
            )
        }
    }
}

@Preview
@Composable
fun GroupsTabContentPreview() {
    DevelopBharatTheme {
        GroupsTabContent(navController = rememberNavController())
    }
}