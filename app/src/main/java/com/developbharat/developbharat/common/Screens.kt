package com.developbharat.developbharat.common

import kotlinx.serialization.Serializable

@Serializable
sealed interface Screens {
    @Serializable
    data object HomeScreen : Screens
}