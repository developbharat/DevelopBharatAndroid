package com.developbharat.developbharat.modules.common.components

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.developbharat.developbharat.common.fillColor
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SmallTopBar(
    title: String,
    subtitle: String? = null,
    hasBackButton: Boolean = false,
    onBackClick: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    navigationIcon: @Composable () -> Unit = {},
) {
    TopAppBar(
        expandedHeight = TopAppBarDefaults.MediumAppBarCollapsedHeight,
        title = {
            Column {
                Text(
                    text = title,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                if (subtitle != null) {
                    Text(
                        text = subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

            }
        },
        navigationIcon = {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
                if (hasBackButton) {
                    IconButton(onClick = { onBackClick() }) {
                        Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Go back")
                    }
                }
                navigationIcon()
            }
        },
        actions = actions
    )
}


@Preview
@Composable
fun PreviewSmallTopBar() {
    DevelopBharatTheme {
        Column {
            SmallTopBar(title = "Home", subtitle = "Loading...")
            SmallTopBar(title = "Home", subtitle = "Loading...", hasBackButton = true)
            SmallTopBar(
                title = "Home",
                subtitle = "Loading...",
                hasBackButton = true,
                navigationIcon = {
                    Icon(
                        Icons.Outlined.Home,
                        contentDescription = "Home",
                        modifier = Modifier.height(IntrinsicSize.Max)
                    )
                })

            SmallTopBar(
                title = "Home",
                subtitle = "Loading...",
                hasBackButton = true,
                navigationIcon = {
                    val bitmap =
                        Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888).fillColor(Color.RED).asImageBitmap()
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Profile Picture",
                        modifier = Modifier
                            .height(IntrinsicSize.Max)
                            .clip(CircleShape)
                    )
                })
        }
    }
}
