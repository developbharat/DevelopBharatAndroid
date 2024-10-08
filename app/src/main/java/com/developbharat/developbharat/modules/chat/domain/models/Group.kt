package com.developbharat.developbharat.modules.chat.domain.models

data class Group(
    val id: Int,
    val name: String,
    val description: String,
    val totalSubscribersCount: Int,
    val lastConversation: Conversation?,
    val unreadConversationsCount: Int,
)