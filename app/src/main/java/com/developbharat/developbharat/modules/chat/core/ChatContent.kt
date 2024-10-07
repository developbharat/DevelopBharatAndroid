package com.developbharat.developbharat.modules.chat.core

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.EmojiObjects
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.VideoSettings
import androidx.compose.ui.graphics.vector.ImageVector
import com.developbharat.developbharat.common.domain.models.UserAccount
import java.time.LocalDateTime

sealed class ChatContent(val shortDescription: String) {
    class TextContent(val data: TextContentData) :
        ChatContent(shortDescription = data.content.substring(0..100))

    class PhotoContent() : ChatContent(shortDescription = "Photo")
    class AudioContent() : ChatContent(shortDescription = "Audio")
    class VideoContent() : ChatContent(shortDescription = "Video")
    class StickerContent() : ChatContent(shortDescription = "Sticker")
}


fun ChatContent.useIcon(): ImageVector? {
    return when (this) {
        is ChatContent.TextContent -> null
        is ChatContent.AudioContent -> Icons.Outlined.Audiotrack
        is ChatContent.VideoContent -> Icons.Outlined.VideoSettings
        is ChatContent.StickerContent -> Icons.Outlined.EmojiObjects
        is ChatContent.PhotoContent -> Icons.Outlined.Photo
    }
}

data class TextContentData(
    val content: String,
    val sender: UserAccount,
    val isSent: Boolean,
    val createdAt: LocalDateTime
)


data class PhotoContentData(
    val filepath: String,
    val thumbnail: String,
    val fileSizeInBytes: Long,
    val md5Sum: String,
)

data class AudioContentData(
    val filepath: String,
    val fileSizeInBytes: Long,
    val md5Sum: String,
)

data class VideoContentData(
    val filepath: String,
    val thumbnail: String,
    val fileSizeInBytes: Long,
    val md5Sum: String,
)