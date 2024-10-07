package com.developbharat.developbharat.common.domain.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.developbharat.developbharat.common.domain.database.dao.UserAccountDao
import com.developbharat.developbharat.common.domain.database.entities.UserAccountRecord
import com.developbharat.developbharat.common.domain.database.mappers.Convertors
import com.developbharat.developbharat.modules.chat.domain.database.dao.ConversationDao
import com.developbharat.developbharat.modules.chat.domain.database.entities.ConversationRecord
import com.developbharat.developbharat.modules.chat.domain.database.entities.DiskFileRecord
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory


@Database(
    entities = [
        // common module
        UserAccountRecord::class,

        // chat module
        ConversationRecord::class,
        DiskFileRecord::class
    ], version = 1, exportSchema = true
)
@TypeConverters(Convertors::class)
abstract class MainDatabase : RoomDatabase() {
    // common module
    abstract fun userAccountDao(): UserAccountDao

    // Chat module
    abstract fun conversationsDao(): ConversationDao


    companion object {
        private const val DB_FILE_NAME = "develop_bharat.db"

        fun createDatabaseInstance(context: Context, password: String): MainDatabase {
            val passphrase: ByteArray = SQLiteDatabase.getBytes(password.toCharArray())
            val factory = SupportFactory(passphrase)

            return Room.databaseBuilder(
                context,
                MainDatabase::class.java,
                DB_FILE_NAME
            )
                .openHelperFactory(factory)
                .build()
        }
    }
}