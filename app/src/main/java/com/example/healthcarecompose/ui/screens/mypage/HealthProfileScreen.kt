package com.example.healthcarecompose.ui.screens.mypage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthcarecompose.ui.components.TopBar

@Composable
fun HealthProfileScreen() {
    Column() {
        TopBar {
            Text(text = "健康档案", color = Color.White)
        }
        var state= remember {
            mutableStateOf(0)
        }
        val item = listOf("基本信息","详细信息")
        TabRow(selectedTabIndex = state.value, backgroundColor = Color.Gray.copy(alpha = 0.2f)) {
            item.forEachIndexed{index, title ->
                Tab(selected = state.value==index, onClick = {
                   state.value=index
                }) {
                    Text(text = title,
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 8.dp))
                }
            }
        }
        Box {
            if (state.value==0){
                AddHealthProfile()
            }else{
                AddDetailHealthProfile()
            }
        }
    }
}

@Preview
@Composable
fun HealthProfileScreenPreview() {
    HealthProfileScreen()
}
