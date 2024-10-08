package com.developbharat.developbharat.modules.chat.screens.home.tabs.contacts

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactsTabViewModel @Inject constructor() : ViewModel() {
    init {
        println("contacts tab initialized")
    }
}