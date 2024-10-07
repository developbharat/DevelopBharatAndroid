package com.developbharat.developbharat.modules.chat.domain.models

import android.graphics.Bitmap
import okio.Path.Companion.toPath
import java.time.LocalDateTime

data class DiskFile(
    val filepath: String,
    val thumbnail: Bitmap,
    val fileSize: Long,
    val md5Sum: String,
    val sentAt: LocalDateTime,
    val createdAt: LocalDateTime,
) {
    val filename = filepath.toPath(normalize = true).name
}
