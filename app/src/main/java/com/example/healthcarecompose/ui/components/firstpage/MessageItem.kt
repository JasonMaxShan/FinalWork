package com.example.healthcarecompose.ui.components.firstpage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthcarecompose.viewmodel.MessageViewModel

@Composable
fun MessageItem(message: MessageViewModel.messgage) {
    Row(modifier = Modifier.padding(horizontal = 8.dp).padding(top = 8.dp)
        .drawBehind {
            drawLine(
                color = Color.Gray,
                start = Offset(0f, size.height),
                end = Offset(size.width, size.height),
            )
        }
    ) {
        Box(modifier = Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primaryVariant)
            .padding(8.dp)
        ) {
            Icon(imageVector = Icons.Filled.Notifications, contentDescription = null, tint = Color.White)
        }
        Column(modifier = Modifier.padding(horizontal = 8.dp).padding(bottom = 8.dp)) {
            if (message.type=="Normal"){
                Text(text = "普通信息")
            }else if (message.type=="Order"){
                Text(text = "支付信息")
            }else{
                Text(text = "警告信息")
            }
            Text(text = message.date, fontSize = 15.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 4.dp))
            Text(
                text = message.body,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 20.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
                    .padding(8.dp)
            )
        }
    }
}
