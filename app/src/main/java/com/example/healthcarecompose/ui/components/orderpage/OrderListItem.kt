package com.example.healthcarecompose.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthcarecompose.model.entity.OrderEntity
import com.example.healthcarecompose.viewmodel.OrderViewModel

@Composable
fun OrderListItem(index:OrderEntity,navController: NavController){
    Column(
        modifier = Modifier
            .clickable{ navController.navigate("OrderDetailScreen/${index.OrderId}") }
            .height(148.dp)
            .fillMaxWidth()
            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2DCDF5).copy(alpha = 0.2f)
            )
    ) {
        Row() {
            Text(text = "${index.OrderName}", fontSize = 25.sp, modifier = Modifier.padding(all = 8.dp))
            Spacer(modifier = Modifier.weight(1f))
            var state:String
            when (index.OrderState) {
                "UNPURCHASED" -> {
                    state= "未付款"
                }
                "PURCHASED" -> {
                    state = "已付款"
                }
                else -> {
                    state= "已完成"
                }
            }
            Text(text = state, modifier = Modifier.padding(all = 8.dp))
        }
        Row() {
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "¥ ${index.RealPurchase}", fontSize = 25.sp, modifier = Modifier.padding(end = 16.dp))
            }
        Row() {
            Text(text = "下单时间：${index.OrderDate} ${index.OrderTime}",modifier = Modifier.padding(start = 16.dp,top=16.dp))
            Spacer(modifier = Modifier.weight(1f))
            Box(modifier = Modifier
                .padding(top = 8.dp,end=8.dp)
                .height(40.dp)
                .width(64.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color.Red.copy(alpha = 0.2f)),
                contentAlignment = Alignment.Center)
             {
                 when (index.OrderState) {
                     "COMMENTED" -> {
                         Text(text = "已评价", color = Color.Gray)
                     }
                     "FIN" -> {
                         Text(text = "待评价", color= Color.Black, modifier = Modifier.clickable {  })
                     }
                     else -> {
                         Text(text = "待评价", color = Color.Gray )
                     }
                 }
            }
        }
    }

}
