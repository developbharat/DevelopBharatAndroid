package com.developbharat.developbharat.modules.common.models

import java.time.LocalDateTime

data class UserAccount(
    val id: Int,
    val name: String,
    val mobile: String,
    val lastSeenAt: LocalDateTime,
) {
    val nameOrMobile: String = if (name.trim().isNotBlank()) name else mobile
}
