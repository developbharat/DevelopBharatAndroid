package com.developbharat.developbharat.modules.chat.core

import kotlinx.serialization.Serializable


@Serializable
sealed interface ChatScreens {
    @Serializable
    data object ChatHomeScreen : ChatScreens
}