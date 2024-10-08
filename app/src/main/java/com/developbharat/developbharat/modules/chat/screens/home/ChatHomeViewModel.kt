package com.developbharat.developbharat.modules.chat.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatHomeViewModel @Inject constructor() : ViewModel() {
    private val _state = mutableStateOf(ChatHomeState())
    val state: State<ChatHomeState> = _state

    fun updateChatsCounts() {
        _state.value =
            _state.value.copy(tabs = ChatTabs.fromUnreadCounts(contacts = 40, groups = 0, bots = 0))
    }
}