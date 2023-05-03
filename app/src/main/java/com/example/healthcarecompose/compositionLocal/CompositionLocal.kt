package com.example.healthcarecompose.compositionLocal

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.healthcarecompose.viewmodel.UserViewModel

val LocalUserViewModel= compositionLocalOf<UserViewModel> { error("LocalUserViewModel not found") }

