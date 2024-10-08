package com.developbharat.developbharat.modules.chat.screens.home.tabs.gropus

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GroupsTabViewModel @Inject constructor(): ViewModel() {
    init {
        println("Groups tab initialized.")
    }
}