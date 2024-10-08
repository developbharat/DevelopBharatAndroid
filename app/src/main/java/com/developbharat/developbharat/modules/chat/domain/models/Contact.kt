package com.developbharat.developbharat.modules.chat.domain.models

import java.time.LocalDateTime

data class Contact(
    val id: Int,
    val name: String,
    val mobile: String,
    val lastSeenAt: LocalDateTime,
    val lastConversation: Conversation?,
    val unreadConversationsCount: Int,
) {
    val nameOrMobile: String = if (name.trim().isNotBlank()) name else mobile
}