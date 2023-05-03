package com.example.healthcarecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthcarecompose.compositionLocal.LocalUserViewModel
import com.example.healthcarecompose.model.entity.AccountOrderItem
import com.example.healthcarecompose.ui.components.OrderListItem
import com.example.healthcarecompose.ui.components.ServiceItem
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.OrderViewModel
import kotlin.reflect.typeOf


@Composable
fun OrderPage(navController: NavController,ovm: OrderViewModel = viewModel(),) {
    val userViewModel= LocalUserViewModel.current
    var NowState by remember { mutableStateOf(0) }
    Column() {
        TopBar {
            Text("我的订单", color = Color.White)
        }
        //四个按钮
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(vertical = 16.dp),
            Alignment.Center){
            Row(modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(horizontal = 16.dp)
                , horizontalArrangement = Arrangement.SpaceAround) {
                ovm.Order.forEachIndexed(){index,order->
                    Column(modifier = Modifier
                        .width(80.dp)
                        .fillMaxHeight()
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
                        .clickable { NowState = index }) {
                        Box(modifier = Modifier
                            .width(80.dp)
                            .padding(top = 16.dp, bottom = 4.dp),
                            contentAlignment = Alignment.Center){
                            Icon(imageVector = order.icon, contentDescription = null)
                        }
                        Box(modifier = Modifier
                            .width(80.dp),
                            contentAlignment = Alignment.Center){
                            Text(text = order.label,textAlign = TextAlign.Center)
                        }
                    }

                }
            }

        }
        //订单列表
        if (userViewModel.logged){
            LazyColumn(){
                when(NowState){
                    0->{
                        items(ovm.OrderList.filter { it.OrderState=="UNPURCHASED" }){index->
                            OrderListItem(index,navController)
                        }
                    }
                    1->{items(ovm.OrderList.filter { it.OrderState=="PURCHASED" }){index->
                        OrderListItem(index,navController)
                    }}
                    2->{items(ovm.OrderList.filter { it.OrderState=="FIN" }){index->
                        OrderListItem(index,navController)
                    }}
                    3->{items(ovm.OrderList){index->
                        OrderListItem(index,navController)
                    }}
                }

            }
        }else{
            Text(text = "您尚未登录")
        }
    }

}
