package com.example.healthcarecompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.UserViewModel

//我的账户详情
@Composable
fun MyAccountPage(uv: UserViewModel = viewModel()) {
    Column() {
        TopBar {
            Text(text = "我的账户", color = Color.White)
        }
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.height(100.dp)) {
            Box(modifier = Modifier.padding(8.dp),contentAlignment = Alignment.Center) {
                Text(text = "您的号码：")
            }
            val Account_number = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = Account_number.value,
                onValueChange = {Account_number.value=it},
                placeholder = { Text(text = Account_number.value.text) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()

            )
        }
        Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.height(100.dp)) {
            Box(modifier = Modifier.padding(8.dp),contentAlignment = Alignment.Center) {
                Text(text = "您的微信：")
            }
            val Wechat_number = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = Wechat_number.value,
                onValueChange = {Wechat_number.value=it},
                placeholder = { Text(text = Wechat_number.value.text) },
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth()

            )
        }
        Row() {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.5f).padding(8.dp)) {
                Text(text = "注销账号")
            }
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(0.5f).padding(8.dp)) {
                Text(text = "退出登录")
            }
        }
    }

}

@Preview
@Composable
fun MyAccountPagePreview() {
    MyAccountPage()
}
