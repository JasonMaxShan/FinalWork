package com.example.healthcarecompose.ui.screens.login

import android.text.method.PasswordTransformationMethod
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.healthcarecompose.compositionLocal.LocalUserViewModel

@Composable
fun LoginScreen(onClose:()->Unit) {
    var UserRole by remember {
        mutableStateOf(true)
    }
    var UserNumber by remember {
        mutableStateOf("")
    }
    var UserPassword by remember {
        mutableStateOf("")
    }
    var ShowPassword by remember {
        mutableStateOf(false)
    }
    val userViewModel= LocalUserViewModel.current
    Column() {
        Row {
            Spacer(modifier = Modifier.weight(1f))
            TextButton(onClick = { UserRole =!UserRole}, modifier = Modifier.padding(all = 16.dp)) {
                Text(text = if (UserRole) "我是医生" else "我是患者")
            }
        }

        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "用户登录", fontSize = 30.sp, modifier = Modifier.padding(all = 16.dp))
            Spacer(modifier = Modifier.height(20.dp))
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(600.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                if(UserRole){
                    Spacer(modifier = Modifier.height(300.dp))
                    Text(text = "微信登录")
                }
                else{
                    Spacer(modifier = Modifier.height(50.dp))
                    TextField(value = UserNumber,
                        onValueChange = {UserNumber=it},
                        singleLine = true,
                        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null)},
                        label = { Text(text = "输入您的号码")},
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    TextField(value = UserPassword,
                        onValueChange = {UserPassword=it},
                        singleLine = true,
                        visualTransformation = if(ShowPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = null)},
                        trailingIcon = { Icon(
                            imageVector = if(ShowPassword) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                            contentDescription = null,
                            modifier = Modifier.clickable { ShowPassword =!ShowPassword })},
                        label = { Text(text = "输入您的密码")},
                        colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent)
                    )
                    Spacer(modifier = Modifier.height(100.dp))
                    TextButton(onClick = { userViewModel.Login(onClose=onClose)}) {
                        Text(text = "登录", fontSize = 20.sp)
                    }
                }

            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "还没有账号？点击注册")
            }
        }

    }

}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen {  }
}
