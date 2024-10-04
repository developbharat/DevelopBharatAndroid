package com.developbharat.developbharat.modules.chat.screens.home.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.developbharat.developbharat.common.ChatContent
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime

@Composable
fun GroupsTabContent() {
    // Chat items
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        // unread message
        item {
            ChatListItem(
                avatar = null,
                name = "Workshop on Sneak Peak into Therapy Room",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                unreadChatsCount = 20
            )
        }

        // read message
        item {
            ChatListItem(
                avatar = null,
                name = "Group B- Sign Language Classes",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
            )
        }
    }
}

@Preview
@Composable
fun GroupsTabContentPreview() {
    DevelopBharatTheme {
        GroupsTabContent()
    }
}