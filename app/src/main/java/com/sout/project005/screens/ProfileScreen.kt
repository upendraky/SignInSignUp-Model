package com.sout.project005.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sout.project005.R

@Composable
@Preview
fun ProfileScreen(
    onNotificaion: () -> Unit = {},
    onCalendar: () -> Unit = {},
    onGallery: () -> Unit = {},
    onPlaylist: () -> Unit = {},
    onShare: () -> Unit = {},
    onLogout: () -> Unit = {}
) {
    val scrollState = rememberScrollState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF3F4F6))
    ) {
        // Background Layer
        Column(modifier = Modifier.fillMaxSize()) {
            // Top Image Background
            Image(
                painter = painterResource(id = R.drawable.arc_pic),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart =102.dp, bottomEnd = 102.dp))
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )

            // White Bottom Container
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                    )
            )
        }

        // Content Layer
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(top = 120.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture with Border and Shadow
            Surface(
                modifier = Modifier
                    .size(120.dp)
                    .shadow(
                        elevation = 8.dp,
                        shape = CircleShape
                    ),
                shape = CircleShape,
                color = Color.White
            ) {
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxSize()
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // User Name
            Text(
                text = "UKY",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF1B1C1E)
            )

            Spacer(modifier = Modifier.height(4.dp))

            // User Email
            Text(
                text = "upendraky415@gmail.com",
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Menu Items List
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                MenuItemRow(
                    icon = Icons.Default.Notifications,
                    title = "Notification",
                    onClick = { /* Handle notification click */ }
                )

                Spacer(modifier = Modifier.height(12.dp))

                MenuItemRow(
                    icon = Icons.Default.DateRange,
                    title = "Calendar",
                    onClick = { /* Handle calendar click */ }
                )

                Spacer(modifier = Modifier.height(12.dp))

                MenuItemRow(
                    icon = Icons.Default.Favorite,
                    title = "Gallery",
                    onClick = { /* Handle calendar click */ }
                )
                

                Spacer(modifier = Modifier.height(12.dp))

                MenuItemRow(
                    icon = Icons.Default.PlayArrow,
                    title = "My Playlist",
                    onClick = { /* Handle playlist click */ }
                )

                Spacer(modifier = Modifier.height(12.dp))

                MenuItemRow(
                    icon = Icons.Default.Share,
                    title = "Share",
                    onClick = { /* Handle share click */ }
                )

                Spacer(modifier = Modifier.height(12.dp))

                MenuItemRow(
                    icon = Icons.Default.ExitToApp,
                    title = "Logout",
                    onClick = { /* Handle logout click */ }
                )

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    }
}

@Composable
fun MenuItemRow(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Surface(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth(),
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Circular Icon Container
            Surface(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFFF0F1F3)
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = title,
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxSize(),
                    tint = Color(0xFF1B1C1E)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Title Text
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1B1C1E),
                modifier = Modifier.weight(1f)
            )

            // End Arrow Icon
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate",
                tint = Color.Gray
            )
        }
    }
}
@Composable
fun MenuItemRow(
    icon: Int,
    title: String,
    showDivider: Boolean = true
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            /* ---------- Icon Container ---------- */
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFF0F1F3)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = icon),
                    contentDescription = title,
                    modifier = Modifier.size(20.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            /* ---------- Title ---------- */
            Text(
                text = title,
                fontSize = 16.sp,
                color = Color(0xFF1B1C1E),
                modifier = Modifier.weight(1f)
            )

            /* ---------- End Arrow ---------- */
            Image(
                painter = painterResource(id = R.drawable.arrow),
                contentDescription = "Arrow",
                modifier = Modifier.size(16.dp)
            )
        }

        if (showDivider) {
            Divider(
                thickness = 0.6.dp,
                color = Color(0xFFE5E7EB)
            )
        }
    }
}
