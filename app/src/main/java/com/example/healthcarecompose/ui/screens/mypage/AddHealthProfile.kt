package com.example.healthcarecompose.ui.screens.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
//添加基础信息
fun AddHealthProfile() {
    Column() {
        val profile_name = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = profile_name.value,
            onValueChange = {profile_name.value=it},
            label = { Text("请输入姓名") },
            leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = null)},
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
        val ID = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = ID.value,
            onValueChange = {ID.value=it},
            label = { Text("请输入身份证号码") },
            leadingIcon = { Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null)},
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        
        )
        val phone_number = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = phone_number.value,
            onValueChange = {phone_number.value=it},
            label = { Text("请输入手机号码") },
            leadingIcon = { Icon(imageVector = Icons.Filled.Phone, contentDescription = null)},
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        )
        Row() {
            Button(onClick = { /*TODO*/ },modifier = Modifier.weight(0.5f).padding(horizontal = 16.dp, vertical = 16.dp)) {
                Text(text = "保存")
            }
        }
        
    }
}

@Preview
@Composable
fun HealthProfilePreview() {
    AddHealthProfile()
}
