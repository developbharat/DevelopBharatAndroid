package com.developbharat.developbharat.modules.chat.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.developbharat.developbharat.common.domain.database.entities.UserAccountRecord
import com.developbharat.developbharat.modules.chat.core.ConversationFormat
import com.developbharat.developbharat.modules.chat.domain.models.Conversation
import java.time.LocalDateTime


@Entity(
    tableName = "conversations", foreignKeys = [ForeignKey(
        entity = UserAccountRecord::class,
        parentColumns = ["id"],
        childColumns = ["sent_from_user_account_id"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = UserAccountRecord::class,
        parentColumns = ["id"],
        childColumns = ["sent_to_user_account_id"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    ), ForeignKey(
        entity = DiskFileRecord::class,
        parentColumns = ["id"],
        childColumns = ["disk_file_id"],
        onUpdate = ForeignKey.CASCADE,
        onDelete = ForeignKey.CASCADE
    )]
)
data class ConversationRecord(
    @ColumnInfo(name = "id", index = true) @PrimaryKey(autoGenerate = true) var id: Int = 0,

    @ColumnInfo("text_content") var textContent: String = "",

    @ColumnInfo("format") var format: ConversationFormat,

    @ColumnInfo(name = "sent_from_user_account_id", index = true) var sentFromUserAccountId: Int,
    @ColumnInfo(name = "sent_to_user_account_id", index = true) var sentToUserAccountId: Int,

    @ColumnInfo(name = "disk_file_id", index = true) var diskFileId: Int? = null,

    @ColumnInfo(name = "sent_or_received_at") var sentOrReceivedAt: LocalDateTime = LocalDateTime.now(),

    @ColumnInfo(name = "is_sent") var isSent: Boolean,

    @ColumnInfo(name = "created_at") var createdAt: LocalDateTime = LocalDateTime.now(),
) {

    companion object {
        fun fromTextContent(
            content: String,
            isSent: Boolean,
            sentFromUserAccountId: Int,
            sentToUserAccountId: Int,
            sentOrReceivedAt: LocalDateTime
        ): ConversationRecord {
            return ConversationRecord(
                textContent = content,
                format = ConversationFormat.TextContent,
                sentFromUserAccountId = sentFromUserAccountId,
                sentToUserAccountId = sentToUserAccountId,
                sentOrReceivedAt = sentOrReceivedAt,
                isSent = isSent
            )
        }

        fun fromDiskFileContent(
            isSent: Boolean,
            sentFromUserAccountId: Int,
            sentToUserAccountId: Int,
            sentOrReceivedAt: LocalDateTime,
            format: ConversationFormat
        ): ConversationRecord {
            return ConversationRecord(
                format = format,
                sentFromUserAccountId = sentFromUserAccountId,
                sentToUserAccountId = sentToUserAccountId,
                sentOrReceivedAt = sentOrReceivedAt,
                isSent = isSent,
            )
        }
    }
}


data class ConversationRecordDbRes(
    @Embedded val conversation: ConversationRecord,
    @Relation(
        entity = DiskFileRecord::class, parentColumn = "disk_file_id", entityColumn = "id"
    ) val diskFile: DiskFileRecord,

    @Relation(
        entity = UserAccountRecord::class, parentColumn = "sent_from_user_account_id", entityColumn = "id"
    ) val sentFromUserAccount: UserAccountRecord,

    @Relation(
        entity = UserAccountRecord::class, parentColumn = "sent_to_user_account_id", entityColumn = "id"
    ) val sentToUserAccount: UserAccountRecord


) {
    fun toConversation(): Conversation {
        return Conversation(
            id = this.conversation.id,
            textContent = this.conversation.textContent,
            format = this.conversation.format,
            sentFromUserAccount = this.sentFromUserAccount.toUserAccount(),
            sentToUserAccount = this.sentToUserAccount.toUserAccount(),
            diskFile = this.diskFile.toDiskFile(),
            sentOrReceivedAt = this.conversation.sentOrReceivedAt,
            isSent = this.conversation.isSent,
            createdAt = this.conversation.createdAt,
        )
    }
}