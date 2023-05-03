package com.example.healthcarecompose.ui.components.orderpage

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
import com.example.healthcarecompose.model.entity.OrderEntity

@Composable
fun OrderDetailItem(order:OrderEntity) {
    Column(
        modifier = Modifier
            .height(148.dp)
            .fillMaxWidth()
            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
    ){
        Row() {
            Text(text = "${order.OrderName}", fontSize = 25.sp, modifier = Modifier.padding(all = 8.dp))
            Spacer(modifier = Modifier.weight(1f))
            var state:String
            when (order.OrderState) {
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
        Spacer(modifier = Modifier.height(20.dp))
        Row() {
            Text(text = "服务价格：", fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "¥ ${order.Price}", fontSize = 16.sp, modifier = Modifier.padding(end = 16.dp))
        }
        Row() {
            Text(text = "其他收费（材料，药物等）：", fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "¥ ${order.ExtraPrice}", fontSize = 16.sp, modifier = Modifier.padding(end = 16.dp))
        }
        Row() {
            Text(text = "实际收款：", fontSize = 16.sp, modifier = Modifier.padding(start = 16.dp))
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "¥ ${order.RealPurchase}", fontSize = 16.sp, modifier = Modifier.padding(end = 16.dp))
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 4.dp, start = 4.dp, end = 4.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
    ){
        Row() {
            Text(text = "下单日期：${order.OrderDate}",modifier = Modifier.padding(start = 16.dp, top = 8.dp))
        }
        Row() {
            Text(text = "下单时间：${order.OrderTime}",modifier = Modifier.padding(start = 16.dp))
        }
        Row() {
            Text(text = "订单编号：${order.OrderId}",modifier = Modifier.padding(start = 16.dp, bottom = 8.dp))
        }

    }

}

