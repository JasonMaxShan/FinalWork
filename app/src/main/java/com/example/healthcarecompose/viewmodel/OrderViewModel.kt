package com.example.healthcarecompose.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddShoppingCart
import androidx.compose.material.icons.filled.ProductionQuantityLimits
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.ShoppingCartCheckout
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.healthcarecompose.model.entity.AccountOrderItem
import com.example.healthcarecompose.model.entity.OrderEntity

class OrderViewModel:ViewModel() {
    val Order by mutableStateOf(listOf(
            AccountOrderItem("待付款", icon = Icons.Filled.ShoppingCartCheckout,"UNPURCHASED"),
            AccountOrderItem("待服务", icon = Icons.Filled.ProductionQuantityLimits,"PURCHASED"),
            AccountOrderItem("待评价", icon = Icons.Filled.AddShoppingCart,"FIN"),
            AccountOrderItem("全部订单", icon = Icons.Filled.ShoppingCart,""),
        )
    )
    //选择的分类下标
    var OrderIndex by mutableStateOf(0)
        private set
    //更新下标
    fun updateCategoryIndex(index: Int){
        OrderIndex=index
    }
    val OrderList by mutableStateOf(listOf(
        OrderEntity(
            "1",
            "外科拆线",
            "Zhejiang",
            "2023-4-19",
            "12:00",
            "2023-4-19",
            "12:02",
            "FIN",
            160.0,
        10.0,
        170.0
        ),
        OrderEntity(
            "2",
            "婴儿护理",
            "Zhejiang",
            "2023-4-19",
            "12:00",
            "2023-4-19",
            "12:02",
            "COMMENTED",
            160.0,
            10.0,
            170.0),
        OrderEntity(
            "3",
            "婴儿护理2",
            "Zhejiang",
            "2023-4-19",
            "12:00",
            "2023-4-19",
            "12:02",
            "PURCHASED",
            160.0,
            10.0,
            170.0),
        OrderEntity(
            "4",
            "婴儿护理",
            "Zhejiang",
            "2023-4-19",
            "12:00",
            "2023-4-19",
            "12:02",
            "UNPURCHASED",
            160.0,
            10.0,
            170.0)
    ))
}