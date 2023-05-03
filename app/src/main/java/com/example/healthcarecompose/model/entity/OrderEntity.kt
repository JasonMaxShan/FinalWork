package com.example.healthcarecompose.model.entity
//订单详情
data class OrderEntity(
    val OrderId:String,
    val OrderName:String,
    val Address:String,
    val OrderDate:String,
    val OrderTime:String,
    val PurchaseDate:String,
    val PurchaseTime:String,
    val OrderState:String,
    val Price: Double,
    val ExtraPrice:Double,
    val RealPurchase:Double
)
