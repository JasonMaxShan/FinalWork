package com.example.healthcarecompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.healthcarecompose.model.entity.AccountEntity

class UserViewModel():ViewModel() {

    var UserInfo:AccountEntity?=null
        private set

    val logged:Boolean
        get(){
            return UserInfo==null
        }


    //登录
    fun Login(onClose:()->Unit){
        UserInfo=AccountEntity("Patient","","","wx1.sinaimg.cn/117.68.34.80:44","test","666")
        onClose()

    }
}