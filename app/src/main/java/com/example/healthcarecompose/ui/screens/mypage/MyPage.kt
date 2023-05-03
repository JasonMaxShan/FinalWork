package com.example.healthcarecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.healthcarecompose.compositionLocal.LocalUserViewModel
import com.example.healthcarecompose.ui.components.MyPageItem
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.MypageViewModel
import kotlin.math.log

@Composable
fun MyPage(navController: NavController,
           mpv:MypageViewModel= viewModel(), ) {
    val userViewModel= LocalUserViewModel.current
    val UserName= userViewModel.UserInfo?.NickName
    Column() {
        //顶栏信息
        TopBar {
            Text("我的主页", color = Color.White)
        }
        //头像与用户名
        Row(modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(vertical = 8.dp)
            ) {
            Spacer(modifier = Modifier.padding(start = 28.dp))
            AsyncImage(
                model = userViewModel.UserInfo?.AvatarUrl,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(1 / 1f)
                    .padding(all = 4.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(all = 16.dp), contentAlignment = Alignment.Center
            ) {
                if (UserName==null){
                    Text(text ="点击登录", fontSize = 30.sp, modifier = Modifier.clickable {  })
                }else
                {
                    Text(text =UserName, fontSize = 30.sp)
                }
            }

        }
        //子页面
        LazyColumn{
            items(mpv.OtherService){index->
                MyPageItem(index,modifier = Modifier.clickable {
                    if (index.label=="我的账户"){
                        navController.navigate("MyAccountPage")
                    }else if (index.label=="我的地址"){
                        navController.navigate("MyAddressScreen")
                    }else if (index.label=="健康档案"){
                        navController.navigate("HealthProfileScreen")
                    }else{
                        navController.navigate("ContactScreen")
                    }
                })
            }
        }
    }

}

