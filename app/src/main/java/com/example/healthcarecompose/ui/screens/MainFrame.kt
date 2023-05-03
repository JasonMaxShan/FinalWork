package com.example.healthcarecompose.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthcarecompose.compositionLocal.LocalUserViewModel
import com.example.healthcarecompose.model.entity.NavigationItem
import com.example.healthcarecompose.viewmodel.MainViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainFrame(
    navController: NavController,
    mvm: MainViewModel = viewModel(),
) {
    val userViewModel= LocalUserViewModel.current
    val NavigationItems= listOf(
        NavigationItem(title = "首页", icon = Icons.Filled.Home),
        NavigationItem(title = "订单", icon = Icons.Filled.Menu),
        NavigationItem(title = "我的", icon = Icons.Filled.Settings)
    )

    Scaffold(bottomBar = {
        BottomNavigation() {
            NavigationItems.forEachIndexed { index, NavigationItem ->
                BottomNavigationItem(
                    selected = mvm.currentNavigationIndex == index,
                    onClick = { mvm.set_currentNavigationIndex(index) },
                    icon = {
                        Icon(imageVector = NavigationItem.icon, contentDescription = null)
                    },
                    label = {
                        Text(text = NavigationItem.title)
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black)
                }
            }
        }){
        Box(modifier = Modifier.padding(it)){
            when(mvm.currentNavigationIndex){
                0-> IndexPage(navController)
                1-> OrderPage(navController)
                2-> MyPage(navController)
            }
        }
    }

}
