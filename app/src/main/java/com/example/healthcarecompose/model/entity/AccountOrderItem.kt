package com.example.healthcarecompose.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

//我的页面订单图标
data class AccountOrderItem(
    val label:String,
    val icon: ImageVector,
    val state:String
)
