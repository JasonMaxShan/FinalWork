package com.example.healthcarecompose.ui.components.mypage


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.MypageViewModel

//联系客服界面
@Composable
fun ContactPage(mvm:MypageViewModel= viewModel()) {
    Column() {
        TopBar {
            Text(text = "联系客服")
        }
        Text(text = "问题类型", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        var expanded by remember { mutableStateOf(false) }
        var selectedIndex by remember { mutableStateOf(0) }
        Box(modifier = Modifier.fillMaxWidth()) {
            Surface(
                border = BorderStroke(2.dp, Color.Gray),
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .clickable { expanded = true }
                    .clip(RoundedCornerShape(4.dp))
                    .fillMaxWidth(),
                elevation = 8.dp
            ) {

                Text(mvm.ContectType[selectedIndex].name, modifier = Modifier.padding(start = 24.dp,top=8.dp, bottom = 8.dp), fontSize = 18.sp)
            }
                DropdownMenu( expanded = expanded, onDismissRequest = { expanded = false }) {
                    mvm.ContectType.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            selectedIndex = index
                            expanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            }
        Text(text = "问题描述", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        val problem_detail = remember { mutableStateOf(TextFieldValue()) }
        TextField(
            value = problem_detail.value,
            onValueChange = { problem_detail.value = it },
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .height(200.dp)
                .fillMaxWidth()
        )
        when(selectedIndex){
            0->Text(text = "账户号码", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
            1->Text(text = "订单号", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
        val other_detail = remember { mutableStateOf(TextFieldValue()) }
        if (selectedIndex==0||selectedIndex==1){
            TextField(
                value = other_detail.value,
                onValueChange ={other_detail.value=it},
                singleLine = true,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
            )
        }
        Row {
            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { mvm.set_problem(mvm.ContectType[selectedIndex].type,problem_detail.value.text,other_detail.value.text) }, modifier = Modifier
                .padding(8.dp)
                .padding(end = 16.dp)) {
                Text("提交", fontSize = 18.sp)
            }
        }

    }
}
@Preview
@Composable
fun ContactPagePreview() {
    ContactPage()
}
