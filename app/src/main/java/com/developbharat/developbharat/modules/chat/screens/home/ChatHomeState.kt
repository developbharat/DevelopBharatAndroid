package com.developbharat.developbharat.modules.chat.screens.home

data class UnreadChatsCount(
    val unreadContactChatsCount: Int = 0,
    val unreadGroupChatsCount: Int = 0,
    val unreadBotChatsCount: Int = 0,
)

data class ChatHomeState(
    val tabs: List<ChatTabs> = ChatTabs.fromUnreadCounts()
)