package com.developbharat.developbharat.modules.chat.domain.models.chatcontent

import com.developbharat.developbharat.modules.common.models.UserAccount
import java.time.LocalDateTime

data class ShortTextContentData(
    val content: String,
    val sender: UserAccount,
    val isSent: Boolean,
    val createdAt: LocalDateTime
){
}