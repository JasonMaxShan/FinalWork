package com.example.healthcarecompose.ui.components

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.healthcarecompose.compositionLocal.LocalUserViewModel
import com.example.healthcarecompose.navigation.Destinations
import com.example.healthcarecompose.ui.components.mypage.ContactPage
import com.example.healthcarecompose.ui.components.orderpage.OrderDetailScreen
import com.example.healthcarecompose.ui.screens.MainFrame
import com.example.healthcarecompose.ui.screens.MyAccountPage
import com.example.healthcarecompose.ui.screens.MyPage
import com.example.healthcarecompose.ui.screens.ServiceDetailPage
import com.example.healthcarecompose.ui.screens.login.LoginScreen
import com.example.healthcarecompose.ui.screens.mypage.AddressSetScreen
import com.example.healthcarecompose.ui.screens.mypage.HealthProfileScreen
import com.example.healthcarecompose.ui.screens.service.MessageScreen
import com.example.healthcarecompose.ui.screens.service.ScheduleScreen
import com.example.healthcarecompose.viewmodel.UserViewModel
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController


//导航封装
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NaviHostApp() {
    val navController = rememberAnimatedNavController()

    CompositionLocalProvider(LocalUserViewModel provides UserViewModel()) {
        val userViewModel= LocalUserViewModel.current
        AnimatedNavHost(navController = navController, startDestination = Destinations.Homeframe.route){
            //首页
            composable(Destinations.Homeframe.route){
                MainFrame(navController)
            }
            //信息页
            composable(Destinations.MessageScreen.route){
                MessageScreen()
            }
            //服务详情页
            composable(Destinations.ServiceDetailPage.route,
                arguments = listOf(
                    navArgument("ServiceID"){
                        type= NavType.StringType
                    }
                )
            ){
                val ServiceID = it.arguments?.getString("ServiceID")?:""
                ServiceDetailPage(navController,ServiceID)
            }
            //预定详情页
            composable(Destinations.ScheduleScreen.route,
                arguments = listOf(
                    navArgument("ServiceID"){
                        type= NavType.StringType
                    }
                )){
                val ServiceID = it.arguments?.getString("ServiceID")?:""
                ScheduleScreen(navController,ServiceID)
            }

            //订单详情页
            composable(Destinations.OrderDetailScreen.route,
                arguments = listOf(
                    navArgument("OrderID"){
                        type= NavType.StringType
                    }
                )){
                val OrderID = it.arguments?.getString("OrderID")?:""
                OrderDetailScreen(navController,OrderID)
            }
            //我的页面
            composable(Destinations.MyPage.route){
                MyPage(navController)
            }
            //我的账户页面
            composable(Destinations.MyAccountPage.route){
                MyAccountPage()
            }
            //我的地址页面
            composable(Destinations.MyAddressScreen.route){
                AddressSetScreen()
            }
            //我的档案界面
            composable(Destinations.HealthProfileScreen.route){
                HealthProfileScreen()
            }
            //联系界面
            composable(Destinations.ContactScreen.route){
                ContactPage()
            }
            //登录页面
            composable(Destinations.Login.route){
                LoginScreen{
                    navController.popBackStack()
                }
            }
        }
        }
    }

@Preview
@Composable
fun NaviHostAppPreview() {
    NaviHostApp()
}
