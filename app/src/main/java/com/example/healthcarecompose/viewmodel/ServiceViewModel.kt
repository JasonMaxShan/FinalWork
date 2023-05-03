package com.example.healthcarecompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.healthcarecompose.model.entity.ServiceEntity

class ServiceViewModel: ViewModel() {
    //服务列表数据
    var ServiceList = listOf(
        ServiceEntity(ServiceID = "1", Class = "1",Title = "外科拆线", Description = "外科手术换线拆药", Price = 100.0, Unit = "RMB/次", imageUrl = "https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        ServiceEntity(ServiceID = "2", Class = "2",Title = "外拆线2", Description = "外科手术换线拆药", Price = 100.0, Unit = "RMB/次", imageUrl = "https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        ServiceEntity(ServiceID = "3", Class = "3", Title = "外科线3", Description = "外科手术换线拆药", Price = 100.0, Unit = "RMB/次", imageUrl = "https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        ServiceEntity(ServiceID = "4", Class = "4",Title = "科拆线4", Description = "外科手术换线拆药", Price = 100.0, Unit = "RMB/次", imageUrl = "https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        ServiceEntity(ServiceID = "5", Class = "5",Title = "科拆线5", Description = "外科手术换线拆药", Price = 100.0, Unit = "RMB/次", imageUrl = "https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        )
        private set


}