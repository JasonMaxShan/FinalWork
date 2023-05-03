package com.example.healthcarecompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.healthcarecompose.model.entity.ServiceEntity
//服务列表
@Composable
fun ServiceItem(Service: ServiceEntity, modifier: Modifier=Modifier) {
    Row(modifier = modifier
        .height(120.dp)
        .fillMaxWidth()
        .padding(top = 4.dp, start = 4.dp, end = 4.dp)
        .clip(RoundedCornerShape(8.dp))
        .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
    ) {
        AsyncImage(
            model = Service.imageUrl,
            contentDescription = null,
            modifier = Modifier
                .aspectRatio(1 / 1f)
                .padding(all = 4.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Column {
            Text(text = Service.Title, fontSize = 20.sp,fontWeight = FontWeight.Bold, maxLines = 1, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = Service.Description, fontSize = 16.sp, maxLines = 2, overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Row() {
                Text(text = Service.Price.toString(),fontWeight = FontWeight.Bold,color = Color.Red)
                Text(text = Service.Unit,fontWeight = FontWeight.Bold, color = Color.Red)
            }
        }
    }
}

