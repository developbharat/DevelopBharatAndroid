package com.developbharat.developbharat.modules.chat.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.developbharat.developbharat.modules.chat.domain.models.Contact
import com.developbharat.developbharat.modules.chat.domain.models.Conversation
import java.time.LocalDateTime

@Entity(
    tableName = "contacts",
    indices = [Index(value = ["mobile"], unique = true)]
)
data class ContactRecord(
    @ColumnInfo(index = true) @PrimaryKey(autoGenerate = true) var id: Int = 0,

    @ColumnInfo(name = "name") var name: String,

    @ColumnInfo(name = "mobile") var mobile: String,

    @ColumnInfo(name = "last_seen_at") var lastSeenAt: LocalDateTime,

    @ColumnInfo(name = "created_at") var createdAt: LocalDateTime = LocalDateTime.now(),
) {
    fun toContact(unreadConversationsCount: Int, lastConversation: Conversation): Contact {
        return Contact(
            id = this.id,
            name = this.name,
            mobile = this.mobile,
            lastSeenAt = this.lastSeenAt,
            unreadConversationsCount = unreadConversationsCount,
            lastConversation = lastConversation
        )
    }
}