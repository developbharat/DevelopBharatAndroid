package com.developbharat.developbharat.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.EmojiObjects
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.VideoSettings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ChatContent(val shortDescription: String) {
    class TextContent(shortDescription: String) : ChatContent(shortDescription = shortDescription)
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