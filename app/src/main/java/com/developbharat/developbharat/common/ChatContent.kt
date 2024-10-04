package com.developbharat.developbharat.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Audiotrack
import androidx.compose.material.icons.outlined.EmojiObjects
import androidx.compose.material.icons.outlined.Photo
import androidx.compose.material.icons.outlined.VideoSettings
import androidx.compose.ui.graphics.vector.ImageVector
import com.developbharat.developbharat.modules.chat.domain.models.chatcontent.ShortTextContentData

sealed class ChatContent(val shortDescription: String) {
    class ShortTextContent(val data: ShortTextContentData) :
        ChatContent(shortDescription = data.content.substring(0..100))
    
    class PhotoContent() : ChatContent(shortDescription = "Photo")
    class AudioContent() : ChatContent(shortDescription = "Audio")
    class VideoContent() : ChatContent(shortDescription = "Video")
    class StickerContent() : ChatContent(shortDescription = "Sticker")
}


fun ChatContent.useIcon(): ImageVector? {
    return when (this) {
        is ChatContent.ShortTextContent -> null
        is ChatContent.AudioContent -> Icons.Outlined.Audiotrack
        is ChatContent.VideoContent -> Icons.Outlined.VideoSettings
        is ChatContent.StickerContent -> Icons.Outlined.EmojiObjects
        is ChatContent.PhotoContent -> Icons.Outlined.Photo
    }
}