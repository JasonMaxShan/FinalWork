package com.example.healthcarecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthcarecompose.navigation.Destinations

import com.example.healthcarecompose.ui.components.NaviHostApp
import com.example.healthcarecompose.ui.components.orderpage.OrderDetailScreen
import com.example.healthcarecompose.ui.screens.MyAccountPage
import com.example.healthcarecompose.ui.screens.ServiceDetailPage
import com.example.healthcarecompose.ui.screens.mypage.AddressSetScreen
import com.example.healthcarecompose.ui.screens.service.MessageScreen
import com.example.healthcarecompose.ui.screens.service.ScheduleScreen

import com.example.healthcarecompose.ui.theme.HealthCareComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WindowCompat.setDecorFitsSystemWindows(window,true)

        setContent {
            HealthCareComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                NaviHostApp()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HealthCareComposeTheme {
        Greeting("Android")
    }
}