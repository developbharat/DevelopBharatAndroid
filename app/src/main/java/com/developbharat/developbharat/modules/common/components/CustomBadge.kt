package com.developbharat.developbharat.modules.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CustomBadge(content: String) {
    Text(
        text = content,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(4.dp))
            .padding(horizontal = 4.dp, vertical = 2.dp),
        color = MaterialTheme.colorScheme.onPrimary
    )
}