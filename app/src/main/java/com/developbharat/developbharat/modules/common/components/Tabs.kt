package com.developbharat.developbharat.modules.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SecondaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

interface ITab {
    val title: String
    val icon: ImageVector?
    val enabled: Boolean
    val badge: String?
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun <TTab : ITab> Tabs(
    initialSelectedTab: Int = 0,
    tabs: List<TTab>,
    content: @Composable (currentTab: TTab) -> Unit,
) {
    var selectedTabIndex by remember { mutableStateOf(initialSelectedTab) }
    val pagerState = rememberPagerState { tabs.size }

    LaunchedEffect(key1 = selectedTabIndex) {
        pagerState.animateScrollToPage(selectedTabIndex)
    }

    LaunchedEffect(key1 = pagerState.currentPage, key2 = pagerState.isScrollInProgress) {
        if (!pagerState.isScrollInProgress) selectedTabIndex = pagerState.currentPage
    }

    Column {
        SecondaryScrollableTabRow(
            selectedTabIndex = selectedTabIndex, edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    enabled = tab.enabled,
                    modifier = Modifier.fillMaxWidth(1f),
                    text = {
                        Row(
                            horizontalArrangement = Arrangement.spacedBy(5.dp),
                            verticalAlignment = Alignment.Bottom,
                            modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 4.dp)
                        ) {
                            if (tab.icon != null) {
                                Icon(
                                    imageVector = tab.icon!!,
                                    contentDescription = "${tab.title} Icon"
                                )
                            }

                            Text(tab.title)

                            if (tab.badge != null) CustomBadge(content = tab.badge!!)
                        }
                    },
                )
            }
        }

        HorizontalPager(state = pagerState) { page ->
            content(tabs[page])
        }
    }
}