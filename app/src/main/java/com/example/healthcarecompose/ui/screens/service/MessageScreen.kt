package com.example.healthcarecompose.ui.screens.service

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.ui.components.firstpage.MessageItem
import com.example.healthcarecompose.viewmodel.MessageViewModel

@Composable
fun MessageScreen(mevm:MessageViewModel= viewModel()) {
    Column() {
        TopBar {
            Text(text = "信息中心", color = Color.White)
        }
        LazyColumn(){
            items(mevm.messagelist){message->
                MessageItem(message)

            }
        }
    }
}

@Preview
@Composable
fun MessageScreenPreview() {
    MessageScreen()
}
