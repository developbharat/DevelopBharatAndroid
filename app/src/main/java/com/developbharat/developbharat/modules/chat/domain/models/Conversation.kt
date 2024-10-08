package com.developbharat.developbharat.modules.chat.domain.models

import com.developbharat.developbharat.common.domain.models.UserAccount
import com.developbharat.developbharat.modules.chat.core.ConversationFormat
import java.time.LocalDateTime

data class Conversation(
    val id: Int,
    val textContent: String,
    val format: ConversationFormat,
    val sentFromUserAccount: UserAccount,
    val sentToUserAccount: UserAccount,
    val diskFile: DiskFile? = null,
    val sentOrReceivedAt: LocalDateTime,
    val isSent: Boolean,
    val isUnread: Boolean,
    val createdAt: LocalDateTime
)