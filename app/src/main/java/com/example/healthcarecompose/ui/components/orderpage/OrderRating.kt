package com.example.healthcarecompose.ui.components.orderpage

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gowtham.ratingbar.RatingBar
import com.gowtham.ratingbar.RatingBarConfig
import com.gowtham.ratingbar.RatingBarStyle

@Composable
fun OrderRating(orderId: String) {
    var rating :Float by remember { mutableStateOf(0.0f) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(
                Color(0xFF2DCDF5).copy(alpha = 0.2f)
            )
    ){
        Text(text = "我的评分", fontSize = 16.sp, modifier = Modifier.padding(8.dp))
        //评分
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), contentAlignment = Alignment.Center) {
            RatingBar(
                value = rating,
                config = RatingBarConfig()
                    .style(RatingBarStyle.HighLighted),
                onValueChange = {
                    rating = it
                },
                onRatingChanged = {
                    Log.d("TAG", "onRatingChanged: $it")
                }
            )
        }
        //评价
        Text(text = "我的评价", fontSize = 16.sp, modifier = Modifier.padding(horizontal = 8.dp))
        val comment = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = comment.value,
            onValueChange = { comment.value = it },
            modifier = Modifier
                .padding(8.dp)
                .height(200.dp)
                .fillMaxWidth()
        )
        Row() {
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = {  }, modifier = Modifier
                .padding(8.dp)
                .padding(end = 16.dp)) {
                Text("提交", fontSize = 18.sp)
            }
        }
    }
}

