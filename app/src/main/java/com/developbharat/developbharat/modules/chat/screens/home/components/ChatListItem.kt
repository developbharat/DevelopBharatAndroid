package com.developbharat.developbharat.modules.chat.screens.home.components

import android.graphics.Bitmap
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.developbharat.developbharat.common.ChatContent
import com.developbharat.developbharat.common.useIcon
import com.developbharat.developbharat.modules.common.components.CustomBadge
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale


@Composable
fun ChatListItem(
    avatar: Bitmap? = null,
    name: String,
    lastMessageAt: LocalDateTime,
    lastChatContent: ChatContent? = null,
    unreadChatsCount: Int = 0,

    ) {
    val hasUnreadChats = unreadChatsCount > 0

    // Read Chat item
    ListItem(leadingContent = {
        if (avatar != null) {
            Image(bitmap = avatar.asImageBitmap(), contentDescription = "$name avatar")
        } else {
            Icon(Icons.Outlined.Person, contentDescription = "User Avatar")
        }

    }, headlineContent = {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                name,
                modifier = Modifier.weight(1f),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.titleSmall,
                fontWeight = if (hasUnreadChats) FontWeight.Medium else FontWeight.Normal
            )

            Text(
                text = lastMessageAt.format(DateTimeFormatter.ofPattern("hh:mm a", Locale.ENGLISH)),
                style = MaterialTheme.typography.labelSmall,
                color = if (hasUnreadChats) MaterialTheme.colorScheme.primary else Color.Unspecified
            )
        }
    }, supportingContent = {
        if (lastChatContent != null) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // 🖼 Photo received
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    val icon = lastChatContent.useIcon()
                    if (icon != null) {
                        Icon(
                            imageVector = icon,
                            contentDescription = lastChatContent.shortDescription,
                            modifier = Modifier.height(15.dp)
                        )
                    }

                    Text(lastChatContent.shortDescription)
                }

                // Badge for unread messages: 20
                if (hasUnreadChats) {
                    CustomBadge(content = unreadChatsCount.toString())
                }
            }
        }
    })
}