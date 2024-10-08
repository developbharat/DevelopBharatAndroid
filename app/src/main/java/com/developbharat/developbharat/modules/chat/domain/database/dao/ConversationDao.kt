package com.developbharat.developbharat.modules.chat.domain.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.developbharat.developbharat.modules.chat.domain.database.entities.ConversationRecord
import com.developbharat.developbharat.modules.chat.domain.database.entities.ConversationRecordDbRes

@Dao
interface ConversationDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(conversations: List<ConversationRecord>)

    @Delete
    suspend fun delete(conversations: List<ConversationRecord>)

    @Delete
    suspend fun delete(conversation: ConversationRecord)

    @Transaction
    @Query("SELECT * FROM conversations WHERE sent_to_user_account_id = :sentToUserAccountId")
    suspend fun listSentToUserAccountConversations(sentToUserAccountId: Int): List<ConversationRecordDbRes>

    @Transaction
    @Query("SELECT * FROM conversations WHERE sent_to_user_account_id = :contactId LIMIT 1;")
    suspend fun findLastContactConversation(contactId: Int): ConversationRecordDbRes?

    @Transaction
    @Query("SELECT COUNT(*) FROM conversations WHERE sent_to_user_account_id = :contactId AND is_unread = 1;")
    suspend fun countUnreadConversations(contactId: Int): Int

}