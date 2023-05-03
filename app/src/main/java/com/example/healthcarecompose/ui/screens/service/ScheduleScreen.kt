package com.example.healthcarecompose.ui.screens.service

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.healthcarecompose.ui.components.TopBar
import com.example.healthcarecompose.viewmodel.MypageViewModel
import com.example.healthcarecompose.viewmodel.ServiceViewModel
import java.util.*

@Composable
fun ScheduleScreen(navController: NavController,
                   ServiceID:String,
                   mvm: MypageViewModel=viewModel(),
                   svm: ServiceViewModel = viewModel()
) {
    Column() {
        val service = svm.ServiceList.find { it.ServiceID==ServiceID }
        //时间
        val mTime = remember { mutableStateOf("") }
        //日期
        val mDate = remember { mutableStateOf("") }
        //病情描述
        val Describe = remember { mutableStateOf("") }
        //是否需要工具
        val Need_tool = remember { mutableStateOf(true) }
        TopBar {
            Text(text = "预约服务", color = Color.White)
        }
        LazyColumn() {

            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(70.dp)
                        .drawBehind {
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.MyLocation,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = "服务地区：")
                    Text(
                        text = if (mvm.user_address.province == null) "您还未设置地址,请前往\"我的\"编辑地址" else "${mvm.user_address.province} 省 " +
                                "${mvm.user_address.city} 市 " +
                                "${mvm.user_address.distinct} 区\n${mvm.user_address.add}",
                        modifier = Modifier.padding(8.dp)
                    )

                }
            }
            item {
                //日期选择器
                val mContext = LocalContext.current

                // Declaring and initializing a calendar
                val mCalendar = Calendar.getInstance()
                val mYear = mCalendar.get(Calendar.YEAR)
                val mMonth = mCalendar.get(Calendar.MONTH)
                val mDay = mCalendar.get(Calendar.DAY_OF_MONTH)
                mCalendar.time = Date()

                // Declaring a string value to
                // store date in string format


                // Declaring DatePickerDialog and setting
                // initial values as current values (present year, month and day)
                val mDatePickerDialog = DatePickerDialog(
                    mContext,
                    { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                        mDate.value = "$mDayOfMonth/${mMonth + 1}/$mYear"
                    }, mYear, mMonth, mDay
                )
                Row(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(70.dp)
                    .drawBehind {
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                        )
                    }
                    .clickable { mDatePickerDialog.show() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.DateRange,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = "预约日期：")
                    Text(
                        text = if (mDate.value == "") "请选择日期" else "${mDate.value}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            item {//时间选择器
                // Fetching local context
                val mContext = LocalContext.current

                // Declaring and initializing a calendar
                val mCalendar = Calendar.getInstance()
                val mHour = mCalendar[Calendar.HOUR_OF_DAY]
                val mMinute = mCalendar[Calendar.MINUTE]

                // Value for storing time as a string

                // Creating a TimePicker dialod
                val mTimePickerDialog = TimePickerDialog(
                    mContext,
                    { _, mHour: Int, mMinute: Int ->
                        mTime.value = "$mHour:$mMinute"
                    }, mHour, mMinute, false
                )
                Row(modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth()
                    .padding(top = 8.dp)
                    .height(70.dp)
                    .drawBehind {
                        drawLine(
                            color = Color.Gray,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                        )
                    }
                    .clickable { mTimePickerDialog.show() },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Schedule,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = "预约时间：")
                    Text(
                        text = if (mTime.value == "") "请选择时间" else "${mTime.value}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(70.dp)
                        .drawBehind {
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = "人员档案：")
                    Text(
                        text = "${mvm.user_profile.name} " +
                                "${mvm.user_profile.Sex} " +
                                "${mvm.user_profile.BirthDate}", modifier = Modifier.padding(8.dp)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .drawBehind {
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextField(
                        value = Describe.value,
                        onValueChange = { Describe.value = it },
                        modifier = Modifier
                            .padding(8.dp)
                            .height(200.dp)
                            .fillMaxWidth(),
                        singleLine = false,
                        placeholder = { Text(text = "请详细描述您的疑问和症状，以及身体情况（最多200字）") }
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(70.dp)
                        .drawBehind {
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Rule,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = "是否需要医师携带工具？")
                    Spacer(modifier = Modifier.weight(1f))
                    Checkbox(
                        checked = Need_tool.value,
                        onCheckedChange = { Need_tool.value = it },
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .height(70.dp)
                        .drawBehind {
                            drawLine(
                                color = Color.Gray,
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                            )
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "预计价格：")
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "服务费 ${service!!.Price}/元"+ if (Need_tool.value) "\n器材费 ${service.Price*0.3}/元" else "")
                }
            }
            item {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {

                    Text("立即预约", fontSize = 18.sp)
                }
            }
        }
    }

}


