package com.example.healthcarecompose.model.entity

import android.os.Parcelable

//服务详情页实体
data class ServiceEntity(
    val ServiceID:String,
    val Class:String,
    val Title:String,
    val Description:String,
    val Price:Double,
    val Unit:String,
    val imageUrl: String
)