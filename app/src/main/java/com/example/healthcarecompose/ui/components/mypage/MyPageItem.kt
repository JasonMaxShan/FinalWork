package com.example.healthcarecompose.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.healthcarecompose.model.entity.AccountOrderItem
//我的页面服务封装
@Composable
fun MyPageItem(index: AccountOrderItem,modifier: Modifier=Modifier) {
    Row(modifier = modifier
        .height(80.dp)
        .fillMaxWidth()
        .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = index.icon, contentDescription = null, modifier = Modifier.padding(horizontal = 16.dp))
        Text(text = index.label)
        Spacer(modifier = Modifier.weight(1f))
        Icon(imageVector = Icons.Filled.ArrowForwardIos, contentDescription = null, modifier = Modifier.padding(end=16.dp))
    }
    Divider()
}


