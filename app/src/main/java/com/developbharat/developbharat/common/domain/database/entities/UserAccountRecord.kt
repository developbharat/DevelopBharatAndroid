package com.developbharat.developbharat.common.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.developbharat.developbharat.common.domain.models.UserAccount
import java.time.LocalDateTime


@Entity(tableName = "user_accounts")
data class UserAccountRecord(
    @ColumnInfo(index = true) @PrimaryKey(autoGenerate = true) var id: Int = 0,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "mobile") val mobile: String,

    @ColumnInfo(name = "last_seen_at") val lastSeenAt: LocalDateTime,
) {
    fun toUserAccount(): UserAccount {
        return UserAccount(
            id = this.id,
            name = this.name,
            mobile = this.mobile,
            lastSeenAt = this.lastSeenAt
        )
    }
}