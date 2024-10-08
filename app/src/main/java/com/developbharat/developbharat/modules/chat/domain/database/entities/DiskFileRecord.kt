package com.developbharat.developbharat.modules.chat.domain.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.developbharat.developbharat.common.core.toBitmap
import com.developbharat.developbharat.modules.chat.domain.models.DiskFile
import java.time.LocalDateTime

@Entity(
    tableName = "disk_files",
    indices = [
        Index(value = ["filepath"], unique = true),
        Index(value = ["md5_sum"], unique = true),
    ]
)
data class DiskFileRecord(
    @ColumnInfo(index = true) @PrimaryKey(autoGenerate = true) var id: Int = 0,

    @ColumnInfo(name = "filepath") var filepath: String,

    @ColumnInfo(name = "thumbnail") var thumbnail: String = "",

    @ColumnInfo(name = "file_size") var fileSizeInBytes: Long,

    @ColumnInfo(name = "md5_sum") var md5Sum: String,

    @ColumnInfo(name = "sent_at") var sentAt: LocalDateTime,

    @ColumnInfo(name = "created_at") var createdAt: LocalDateTime = LocalDateTime.now(),
) {
    fun toDiskFile(): DiskFile {
        return DiskFile(
            filepath = this.filepath,
            thumbnail = this.thumbnail.toBitmap(),
            fileSize = this.fileSizeInBytes,
            md5Sum = this.md5Sum,
            sentAt = this.sentAt,
            createdAt = this.createdAt,
        )
    }
}