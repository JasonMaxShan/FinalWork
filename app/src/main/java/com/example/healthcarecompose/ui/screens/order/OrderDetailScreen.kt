package com.example.healthcarecompose.ui.components.orderpage

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.OrderViewModel

@Composable
fun OrderDetailScreen(
    navController: NavController,
    OrderID:String,
    ovm: OrderViewModel = viewModel()) {
    val order=ovm.OrderList.find { it.OrderId==OrderID }
    Column {
        TopBar {
            Text(text = "订单详情", color = Color.White)
        }
        OrderDetailItem(order!!)
        if (order.OrderState=="FIN"){
            OrderRating(order.OrderId)
        }else if (order.OrderState=="PURCHASED"){
            OrderMap()
        }else if(order.OrderState=="UNPURCHASED"){
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Button(onClick = { } , modifier = Modifier
                    .padding(8.dp)
                    .weight(0.3f)
                    ) {
                    Text("取消订单", fontSize = 18.sp)
                }
                Button(onClick = { } , modifier = Modifier
                    .padding(8.dp)
                    .weight(0.3f)
                    ) {
                    Text("支付订单", fontSize = 18.sp)
                }
            }

        }

    }
}
