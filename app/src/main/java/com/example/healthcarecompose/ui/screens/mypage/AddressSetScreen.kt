package com.example.healthcarecompose.ui.screens.mypage


import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.MypageViewModel

@Composable
fun AddressSetScreen(mvm:MypageViewModel= viewModel()) {
    Column() {
        val Province = remember { mutableStateOf(TextFieldValue()) }
        val City = remember { mutableStateOf(TextFieldValue()) }
        val Distinct = remember { mutableStateOf(TextFieldValue()) }
        TopBar {
            Text(text = "地址管理", color = Color.White)
        }
        Text(text = "区域地址", modifier = Modifier.padding(8.dp), fontSize = 20.sp)
        Row() {

            OutlinedTextField(
                value = Province.value,
                onValueChange = {Province.value=it},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(0.3f)
            )
            Text(text = "省")

            OutlinedTextField(
                value = City.value,
                onValueChange = {City.value=it},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(0.3f)
            )
            Text(text = "市")

            OutlinedTextField(
                value = Distinct.value,
                onValueChange = {Distinct.value=it},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .weight(0.3f)
            )
            Text(text = "区")
        }
        Text(text = "详细地址", modifier = Modifier.padding(8.dp), fontSize = 20.sp)
        val address = remember { mutableStateOf(TextFieldValue()) }
        OutlinedTextField(
            value = address.value,
            onValueChange = {address.value=it},
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            singleLine = true
        )
        Row() {
            Button(onClick = { mvm.set_user_address(Province.value.text,City.value.text,Distinct.value.text,address.value.text) },modifier = Modifier
                .weight(0.5f)
                .padding(horizontal = 16.dp, vertical = 16.dp)) {
                Text(text = "保存")
            }
        }
        }
    }


@Preview
@Composable
fun AddressSetScreenPreview() {
    AddressSetScreen()
}
