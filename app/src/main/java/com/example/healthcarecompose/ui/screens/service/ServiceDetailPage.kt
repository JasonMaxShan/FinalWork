package com.example.healthcarecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthcarecompose.ui.components.ServiceItem
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.DetailServiceviewModel
import com.example.healthcarecompose.viewmodel.MainViewModel
import com.example.healthcarecompose.viewmodel.ServiceViewModel
import java.security.Provider.Service

//服务详情页
@Composable
fun ServiceDetailPage(
    navController: NavController,
    ServiceID:String,
    dsm: DetailServiceviewModel = viewModel(),
    svm: ServiceViewModel = viewModel(),
) {
    Column() {
        val Service = dsm.example.find { it.ServiceID==ServiceID }
        TopBar {
            Text(text = "服务详情")
        }
        LazyColumn(){
            item {
                Box() {
                    svm.ServiceList.find { it.ServiceID==ServiceID }?.let { ServiceItem(it) }
                }
            }
            item { 
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column() {
                        Text(text = "-服务详情-", fontSize = 20.sp)
                    }
                }
            }
            item{
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column() {
                        Text(text = Service?.Describe ?: "")
                    }
                }
            }
            item {
                Box(contentAlignment = Alignment.Center, modifier = Modifier

                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column() {
                        Text(text = "-服务提示-", fontSize = 20.sp)
                    }
                }
            }
            item{
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column() {
                        Text(text = Service?.Remind ?: "")
                    }
                }
            }
            item {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                    Column() {
                        Text(text = "-如需退款-", fontSize = 20.sp)
                    }
                }
            }
            item {
                Box(contentAlignment = Alignment.Center, modifier = Modifier
                    .background(Color(0xFF2DCDF5).copy(alpha = 0.2f))
                    .fillMaxWidth()
                    .padding(8.dp)
                    ) {
                    Column() {
                        Text(text = "1、套餐内按使用次数计算服务费，剩余金额退回；\n" +
                                "2、10元以上代金券不予计算不予退还；\n" +
                                "3、退款均在1-15个工作日内返回到支付账户；\n" +
                                "4、凡需立即上门（1小时内）和特殊时间段（21:00-6:00）上门服务的，需另付加急费30-50元，否则护士可以拒绝提供服务。")
                    }
                }
            }
            item { Row() {
                Button(onClick = { navController.navigate("ScheduleScreen/${ServiceID}") },modifier = Modifier.weight(0.5f).padding(horizontal = 16.dp, vertical = 16.dp)) {
                    Text(text = "下一步")
                }
            } }
        }
    }
    
    
    
}

