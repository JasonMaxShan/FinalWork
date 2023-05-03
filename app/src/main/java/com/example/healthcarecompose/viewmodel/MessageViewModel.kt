package com.example.healthcarecompose.viewmodel

import androidx.lifecycle.ViewModel
import java.util.Date

class MessageViewModel:ViewModel() {
    data class messgage(
        val type:String,
        val body:String,
        val date:String
    )

    val messagelist= listOf(
        messgage("Normal","Test","2023-4-27"),
        messgage("Order","Test","2023-4-27"),
        messgage("Warn","Test","2023-4-27")
    )
}