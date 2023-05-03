package com.example.healthcarecompose.ui.screens.mypage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.healthcarecompose.viewmodel.MypageViewModel

@Composable
fun AddDetailHealthProfile(mvm: MypageViewModel = viewModel()) {
    LazyColumn{
        item{
            //名族
            val nation = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = nation.value,
                onValueChange = {nation.value=it},
                singleLine = true,
                label = { Text("请输入民族")},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()

            )
        }
        item { //血型
            var Bloodexpanded by remember { mutableStateOf(false) }
            var BloodIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { Bloodexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("请输入血型", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.BloodType[BloodIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }
                }
                DropdownMenu( expanded = Bloodexpanded, onDismissRequest = { Bloodexpanded = false }) {
                    mvm.BloodType.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            BloodIndex = index
                            Bloodexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //RH
            var RHexpanded by remember { mutableStateOf(false) }
            var RHIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { RHexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("RH阴性", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.RH_negative[RHIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }}
                DropdownMenu( expanded = RHexpanded, onDismissRequest = { RHexpanded = false }) {
                    mvm.RH_negative.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            RHIndex = index
                            RHexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //教育程度
            var Learnexpanded by remember { mutableStateOf(false) }
            var LearnIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { Learnexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("受教育程度", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.Educational_level[LearnIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }}
                DropdownMenu( expanded = Learnexpanded, onDismissRequest = { Learnexpanded = false }) {
                    mvm.Educational_level.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            LearnIndex = index
                            Learnexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //人群属性
            var Peoplexpanded by remember { mutableStateOf(false) }
            var PeopleIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { Peoplexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("人群属性", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.People_type[PeopleIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }}
                DropdownMenu( expanded = Peoplexpanded, onDismissRequest = { Peoplexpanded = false }) {
                    mvm.People_type.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            PeopleIndex = index
                            Peoplexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //吸烟
            var Smokexpanded by remember { mutableStateOf(false) }
            var SmokeIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { Smokexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("是否吸烟", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.smoke[SmokeIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }
                }
                DropdownMenu( expanded = Smokexpanded, onDismissRequest = { Smokexpanded = false }) {
                    mvm.smoke.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            SmokeIndex = index
                            Smokexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //饮酒
            var Alcoholexpanded by remember { mutableStateOf(false) }
            var AlcoholIndex by remember { mutableStateOf(0) }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)) {
                Surface(
                    border = BorderStroke(2.dp, Color.Gray),
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .clickable { Alcoholexpanded = true }
                        .clip(RoundedCornerShape(4.dp))
                        .fillMaxWidth(),
                    elevation = 8.dp
                ) {
                    Row() {
                        Text("是否饮酒", modifier = Modifier
                            .padding(all = 8.dp)
                            .width(200.dp), fontSize = 18.sp, color = Color.Gray)
                        Text(mvm.alcohol[AlcoholIndex].name, modifier = Modifier.padding(start = 30.dp, top=8.dp, bottom = 8.dp), fontSize = 18.sp)

                    }
                }
                DropdownMenu( expanded = Alcoholexpanded, onDismissRequest = { Alcoholexpanded = false }) {
                    mvm.alcohol.forEachIndexed { index, s ->
                        DropdownMenuItem( onClick = {
                            AlcoholIndex = index
                            Alcoholexpanded = false
                        }) {
                            Text(text = s.name, fontSize = 18.sp)
                        }

                    }
                }
            } }
        item { //过敏史
            Text(text ="过敏史", modifier = Modifier.padding(all=8.dp))
            val Allergy_history = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = Allergy_history.value,
                onValueChange = {Allergy_history.value=it},
                label={ Text("若存在，请输入过敏史")},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(150.dp)

            ) }
        item { //家族史
            Text(text ="家族史", modifier = Modifier.padding(all=8.dp))
            val Family_history = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = Family_history.value,
                onValueChange = {Family_history.value=it},
                label={ Text("若存在，请输入家族史")},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(150.dp)

            ) }
        item { //既往病史
            Text(text ="既往病史", modifier = Modifier.padding(all=8.dp))
            val Previous_history = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = Previous_history.value,
                onValueChange = {Previous_history.value=it},
                label={ Text("若存在，请输入既往病史")},
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .height(150.dp)

            ) }
        item {
            Row() {
                Button(onClick = { /*TODO*/ },modifier = Modifier.weight(0.5f).padding(horizontal = 16.dp, vertical = 16.dp)) {
                    Text(text = "保存")
                }
            }
        }
    }


}

@Preview
@Composable
fun AddDetailHealthProfilePreview() {
    AddDetailHealthProfile()
}
