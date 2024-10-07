package com.developbharat.developbharat.common.domain.models

import com.developbharat.developbharat.common.domain.database.entities.UserAccountRecord
import java.time.LocalDateTime

data class UserAccount(
    val id: Int,
    val name: String,
    val mobile: String,
    val lastSeenAt: LocalDateTime,
) {
    val nameOrMobile: String = if (name.trim().isNotBlank()) name else mobile

    fun toDatabaseRecord(): UserAccountRecord {
        return UserAccountRecord(id = this.id, name = this.name, mobile = this.mobile, lastSeenAt = this.lastSeenAt)
    }
}
