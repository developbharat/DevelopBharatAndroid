package com.developbharat.developbharat.modules.chat.screens.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Contacts
import androidx.compose.material.icons.outlined.Group
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.SmartToy
import androidx.compose.material.icons.outlined.SpatialAudio
import androidx.compose.material.icons.outlined.SpeakerGroup
import androidx.compose.ui.graphics.vector.ImageVector
import com.developbharat.developbharat.common.components.ITab

sealed class ChatTabs(
    override val title: String,
    override val icon: ImageVector? = null,
    override val enabled: Boolean = true,
    override val badge: String? = null
) :
    ITab {
    class Contacts(unreadCount: Int? = null) :
        ChatTabs(
            title = "Contacts",
            icon = Icons.Outlined.Group,
            enabled = true,
            badge = if (unreadCount == null || unreadCount <= 0) null else unreadCount.toString()
        )

    class Groups(unreadCount: Int? = null) :
        ChatTabs(
            title = "Groups",
            icon = Icons.Outlined.Groups,
            enabled = true,
            badge = if (unreadCount == null || unreadCount <= 0) null else unreadCount.toString()
        )

    class Bots(unreadCount: Int? = null) : ChatTabs(
        title = "Bots",
        icon = Icons.Outlined.SmartToy,
        enabled = true,
        badge = if (unreadCount == null || unreadCount <= 0) null else unreadCount.toString()
    )

    companion object {
        fun fromUnreadCounts(
            contacts: Int? = null,
            groups: Int? = null,
            bots: Int? = null
        ): List<ChatTabs> {
            return listOf(
                Contacts(unreadCount = contacts),
                Groups(unreadCount = groups),
                Bots(unreadCount = bots)
            )
        }
    }
}