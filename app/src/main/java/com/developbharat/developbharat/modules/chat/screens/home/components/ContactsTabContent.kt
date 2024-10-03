package com.developbharat.developbharat.modules.chat.screens.home.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.developbharat.developbharat.common.ChatContent
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime

@Composable
fun ContactsTabContent() {
    // Chat items
    LazyColumn {
        // unread message
        item {
            ChatListItem(
                avatar = null,
                name = "Shubendu CDIS IIT Stock Market Chandigarh",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
                unreadChatsCount = 20
            )
        }

        // read message
        item {
            ChatListItem(
                avatar = null,
                name = "Shubendu CDIS IIT Stock Market Chandigarh",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
            )
        }

        // unsaved contact message
        item {
            ChatListItem(
                avatar = null,
                name = "+91 701 510 8956",
                lastMessageAt = LocalDateTime.now(),
                lastChatContent = ChatContent.PhotoContent(),
            )
        }
    }
}

@Preview
@Composable
fun ContactsTabContentPreview() {
    DevelopBharatTheme {
        ContactsTabContent()
    }
}