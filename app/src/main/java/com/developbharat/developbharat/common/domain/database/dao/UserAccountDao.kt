package com.developbharat.developbharat.common.domain.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.developbharat.developbharat.common.domain.database.entities.UserAccountRecord

@Dao
interface UserAccountDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(account: UserAccountRecord)

    @Delete
    suspend fun delete(account: UserAccountRecord)

    @Query("SELECT * FROM user_accounts WHERE id = :accountId LIMIT 1;")
    suspend fun getAccountById(accountId: Int): UserAccountRecord?
}