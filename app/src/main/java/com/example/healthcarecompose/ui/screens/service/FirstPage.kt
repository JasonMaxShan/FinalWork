package com.example.healthcarecompose.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.WbSunny
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthcarecompose.ui.components.TopBar
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.healthcarecompose.navigation.Destinations
import com.example.healthcarecompose.ui.components.HorizontalPage
import com.example.healthcarecompose.ui.components.ServiceItem
import com.example.healthcarecompose.viewmodel.MainViewModel
import com.example.healthcarecompose.viewmodel.ServiceViewModel

//进入后的首页
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun IndexPage(
    navController: NavController,
    vm: MainViewModel =viewModel(),
    svm:ServiceViewModel= viewModel(),
    ) {
    Column {
        //标题栏
        TopBar() {
            Spacer(modifier = Modifier.width(8.dp))
            //搜索按钮
            Surface(modifier= Modifier
                .clip(RoundedCornerShape(16.dp))
                .weight(1f),
                    color = Color(0x33FFFFFF)
                ) {
                Row(
                    modifier = Modifier.padding(
                        horizontal = 8.dp,
                        vertical = 4.dp
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint =Color.White, modifier = Modifier.size(
                        20.dp
                    ))
                    Text(text = "搜索感兴趣的医疗服务", color = Color.White, fontSize = 16.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            //天气内容
            Text(text = "晴天\n36°C", color = Color.White, fontSize = 14.sp,modifier = Modifier.padding(all = 4.dp))
            Icon(imageVector = Icons.Filled.WbSunny, contentDescription = null, tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            //通知
            Icon(imageVector = Icons.Filled.Notifications,
                contentDescription = null,
                modifier = Modifier.padding(all = 4.dp)
                    .clickable { navController.navigate("MessageScreen") },
                tint = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
        }

        //轮播图
        HorizontalPage()
        //分类栏
        TabRow(selectedTabIndex = vm.categoryIndex, backgroundColor = Color.Gray.copy(alpha = 0.2f)) {
            vm.categories.forEachIndexed{index, category ->
                Tab(selected = vm.categoryIndex==index, onClick = {
                    vm.updateCategoryIndex(index)
                }) {
                    Text(text = category.title,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
            }
        }
        //服务列表
        LazyColumn(){
            //服务列表
            if(vm.categoryIndex==0){
                items(svm.ServiceList.filter { it.Class=="1" }){Service ->
                    ServiceItem(Service, modifier = Modifier.clickable { navController.navigate("ServiceDetailPage/${Service.ServiceID}") })
                }
            }else if(vm.categoryIndex==1){
                items(svm.ServiceList.filter { it.Class=="2" }){Service ->
                    ServiceItem(Service, modifier = Modifier.clickable { navController.navigate("ServiceDetailPage/${Service.ServiceID}") })
                }
            }
            else if(vm.categoryIndex==2){
                items(svm.ServiceList.filter { it.Class=="3" }){Service ->
                    ServiceItem(Service, modifier = Modifier.clickable { navController.navigate("ServiceDetailPage/${Service.ServiceID}") })
                }
            }
            else if(vm.categoryIndex==3){
                items(svm.ServiceList.filter { it.Class=="4" }){Service ->
                    ServiceItem(Service, modifier = Modifier.clickable { navController.navigate("ServiceDetailPage/${Service.ServiceID}") })
                }
            }
            else{
                items(svm.ServiceList.filter { it.Class=="5" }){Service ->
                    ServiceItem(Service, modifier = Modifier.clickable { navController.navigate("ServiceDetailPage/${Service.ServiceID}") })
                }
            }
        }
        }
    }

