package com.developbharat.developbharat.modules.chat.screens.communicate

import android.graphics.Bitmap
import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.outlined.AttachFile
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Videocam
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.developbharat.developbharat.modules.chat.core.ChatContent
import com.developbharat.developbharat.common.fillColor
import com.developbharat.developbharat.modules.chat.core.TextContentData
import com.developbharat.developbharat.modules.common.components.SmallTopBar
import com.developbharat.developbharat.modules.common.models.UserAccount
import com.developbharat.developbharat.ui.theme.DevelopBharatTheme
import java.time.LocalDateTime


@Composable
fun ChatCommunicateScreen(navController: NavController) {
    Scaffold(topBar = {
        SmallTopBar(title = "Shubendu CDIS IIT Stock Market Chandigarh",
            subtitle = "+91 701 510 8956",
            hasBackButton = true,
            onBackClick = { navController.popBackStack() },
            navigationIcon = {
                val bitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888).fillColor(Color.RED).asImageBitmap()
                Image(
                    bitmap = bitmap,
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .height(35.dp)
                        .clip(CircleShape)
                )
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Phone, contentDescription = "Phone call")
                }
                IconButton(onClick = {}) {
                    Icon(Icons.Outlined.Videocam, contentDescription = "Video Call")
                }
                IconButton(onClick = {}) {
                    Icon(
                        Icons.Outlined.MoreVert, contentDescription = "More"
                    )
                }
            })
    }) { paddingValues ->
        Surface(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(verticalArrangement = Arrangement.SpaceBetween) {
                // Messages Preview
                LazyColumn(
                    modifier = Modifier
                        .padding(20.dp)
                        .weight(1f),
                    verticalArrangement = Arrangement.spacedBy(30.dp)
                ) {
                    item {
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
                            textContent = ChatContent.TextContent(
                                data = TextContentData(
                                    content = expandedString,
                                    sender = sender,
                                    isSent = true,
                                    createdAt = LocalDateTime.now()
                                )
                            )
                        )
                    }

                    item {
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
                            textContent = ChatContent.TextContent(
                                data = TextContentData(
                                    content = expandedString,
                                    sender = sender,
                                    isSent = false,
                                    createdAt = LocalDateTime.now()
                                )
                            )
                        )
                    }
                }

                // Send Box
                Column(
                    verticalArrangement = Arrangement.spacedBy(5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Buttons
//                    Row(
//                        verticalAlignment = Alignment.CenterVertically,
//                        horizontalArrangement = Arrangement.spacedBy(4.dp),
//                        modifier = Modifier
//                            .background(MaterialTheme.colorScheme.primaryContainer)
//                            .fillMaxWidth()
//                    ) {
//                        IconButton(onClick = {}) {
//                            Icon(Icons.Outlined.LocationOn, contentDescription = "Share Location")
//                        }
//
//                        IconButton(onClick = {}) {
//                            Icon(Icons.Outlined.Camera, contentDescription = "Camera")
//                        }
//
//                        IconButton(onClick = {}) {
//                            Icon(Icons.Outlined.Photo, contentDescription = "Attach Photos")
//                        }
//                    }

                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 5.dp, vertical = 5.dp),
                        value = "",
                        onValueChange = {},
                        label = { Text("Your message") },
                        leadingIcon = {
                            IconButton(onClick = {}) {
                                Icon(Icons.Outlined.AttachFile, contentDescription = "Attach File")
                            }
                        },
                        trailingIcon = {
                            IconButton(onClick = {}) {
                                Icon(
                                    Icons.AutoMirrored.Outlined.Send,
                                    contentDescription = "Send"
                                )
                            }
                        }
                    )

                }
            }
        }
    }
}


@Preview
@Composable
fun ChatCommunicateScreenPreview() {
    DevelopBharatTheme {
        ChatCommunicateScreen(navController = rememberNavController())
    }
}