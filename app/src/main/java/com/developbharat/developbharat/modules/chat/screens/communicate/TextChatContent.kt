package com.developbharat.developbharat.modules.chat.screens.communicate

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.developbharat.developbharat.common.ChatContent
import com.developbharat.developbharat.modules.chat.domain.models.chatcontent.ShortTextContentData
import com.developbharat.developbharat.modules.common.models.UserAccount
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun TextChatContent(textContent: ChatContent.ShortTextContent) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    OutlinedCard(
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = if (textContent.data.isSent) 50.dp else 0.dp,
                top = 0.dp,
                end = if (textContent.data.isSent) 0.dp else 50.dp,
                bottom = 0.dp
            ),
    ) {
        Row(
            modifier = Modifier
                .drawBehind {
                    val strokeWidth = 1 * density
                    val y = size.height - strokeWidth / 2
                    drawLine(Color.LightGray, Offset(0f, y), Offset(size.width, y), strokeWidth)
                }
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = textContent.data.sender.nameOrMobile,
                fontSize = 10.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
            )

            Text(
                text = textContent.data.createdAt
                    .format(DateTimeFormatter.ofPattern("hh:mm a"))
                    .uppercase(Locale.ENGLISH),
                fontSize = 10.sp,
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.labelSmall,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp)
            )
        }

        Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.Top) {
            Text(
                maxLines = if (expanded) Int.MAX_VALUE else 7,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                text = textContent.data.content
            )

            Text(
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { expanded = !expanded },
                text = if (expanded) "Show less" else "Show more",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview
@Composable
fun SentChatContentPreview() {
    DevelopBharatTheme {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            val expandedString =
                "It consists of a reactive programming model with conciseness and ease of Kotlin programming language. It is fully declarative so that you can describe your UI by calling some series of functions that will transform your data into a UI hierarchy. When the data changes or is updated then the framework automatically recalls these functions and updates the view for you.\n" +
                        "\n" +
                        "Composable Function is represented in code by using @Composable annotation to the function name. This function will let you define your app’s UI programmatically by describing its shape and data dependencies rather than focusing on the UI construction process. "

            val sender = UserAccount(
                id = 1,
                name = "Shubendu CDIS IITK Chandigarh",
                mobile = "+91 701 510 8956",
                lastSeenAt = LocalDateTime.now()
            )
            TextChatContent(
                textContent = ChatContent.ShortTextContent(
                    data = ShortTextContentData(
                        content = expandedString,
                        sender = sender,
                        isSent = true,
                        createdAt = LocalDateTime.now()
                    )
                )
            )

            TextChatContent(
                textContent = ChatContent.ShortTextContent(
                    data = ShortTextContentData(
                        content = expandedString,
                        sender = sender,
                        isSent = false,
                        createdAt = LocalDateTime.now()
                    )
                )
            )
        }
    }
}