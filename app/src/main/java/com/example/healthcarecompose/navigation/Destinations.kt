package com.example.healthcarecompose.navigation
//页面导航管理
sealed class Destinations(val route:String){
    //首页框架
    object Homeframe:Destinations("HomeFrame")
    //首页
    object FirstScreen:Destinations("FirstScreen")
    //订单页
    object OrderScreen:Destinations("OrderScreen")
    //我的页面
    object MyPage:Destinations("MyPage")
    //服务详情页
    object ServiceDetailPage:Destinations("ServiceDetailPage/{ServiceID}")
    //预约界面
    object ScheduleScreen:Destinations("ScheduleScreen/{ServiceID}")
    //订单详情页
    object OrderDetailScreen:Destinations("OrderDetailScreen/{OrderID}")
    //我的账户页面
    object MyAccountPage:Destinations("MyAccountPage")
    //我的地址页面
    object MyAddressScreen:Destinations("MyAddressScreen")
    //健康档案详情页
    object HealthProfileScreen:Destinations("HealthProfileScreen")
    //联系客服页面
    object ContactScreen:Destinations("ContactScreen")
    //登录
    object Login:Destinations("Login")
    //通知页面
    object MessageScreen:Destinations("MessageScreen")
}
