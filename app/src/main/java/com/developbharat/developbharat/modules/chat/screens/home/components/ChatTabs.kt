package com.developbharat.developbharat.modules.chat.screens.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

sealed class ChatTab(val label: String) {
    class Contacts : ChatTab("Contacts")
    class Groups : ChatTab("Groups")
    class Bots : ChatTab("Bots")

    companion object {
        val AllTabs = listOf(Contacts(), Groups(), Bots())
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatTabs(
    defaultSelectedTab: Int = 0,
    content: @Composable (currentTab: ChatTab) -> Unit
) {
    var selectedTabIndex by remember { mutableStateOf(defaultSelectedTab) }

    Column {
        SecondaryScrollableTabRow(
            selectedTabIndex = selectedTabIndex, edgePadding = 0.dp
        ) {
            ChatTab.AllTabs.forEachIndexed { index, tab ->
                Tab(selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(tab.label) })
            }
        }

        content(ChatTab.AllTabs[selectedTabIndex])

//        HorizontalPager(
//            state = PagerState(
//                currentPage = selectedTabIndex,
//                currentPageOffsetFraction = 0.0f,
//                pageCount = { ChatTab.AllTabs.size }
//            )
//        ) { page ->
//            content(ChatTab.AllTabs[page])
//        }

//        AnimatedContent(
//            targetState = selectedTabIndex,
//            transitionSpec = {
//                // Compare the incoming number with the previous number.
//                if (targetState > initialState) {
//                    // If the target number is larger, it slides up and fades in
//                    // while the initial (smaller) number slides up and fades out.
//                    slideInHorizontally { height -> height } + fadeIn() togetherWith
//                            slideOutHorizontally { height -> -height } + fadeOut()
//                } else {
//                    // If the target number is smaller, it slides down and fades in
//                    // while the initial number slides down and fades out.
//                    slideInHorizontally { height -> -height } + fadeIn() togetherWith
//                            slideOutHorizontally { height -> height } + fadeOut()
//                }.using(
//                    // Disable clipping since the faded slide-in/out should
//                    // be displayed out of bounds.
//                    SizeTransform(clip = false)
//                )
//            },
//            label = "Tab content"
//        ) { currentTab ->
//            HorizontalPager(state=currentTab) {
//                content(ChatTab.AllTabs[currentTab])
//            }
//    }
    }
}