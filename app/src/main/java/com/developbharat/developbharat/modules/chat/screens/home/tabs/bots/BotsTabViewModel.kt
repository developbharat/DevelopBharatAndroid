package com.developbharat.developbharat.modules.chat.screens.home.tabs.bots

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BotsTabViewModel @Inject constructor() : ViewModel() {
    init {
        println("Bots tab initialized.")
    }
}