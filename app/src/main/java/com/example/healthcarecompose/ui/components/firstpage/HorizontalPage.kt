package com.example.healthcarecompose.ui.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.Disposable
import com.example.healthcarecompose.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import java.util.Timer
import java.util.TimerTask

//轮播图组件
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPage(vm: MainViewModel = viewModel()) {
    //虚拟页数
    val VirtualPage:Int = 50000
    //实际页数
    val ActualPage:Int = vm.swipeData.size
    //初始页数
    val InitialPage:Int = VirtualPage/2+(VirtualPage/2)%ActualPage
    //
    val PaperState = rememberPagerState(initialPage = InitialPage)
    val coroutineScope= rememberCoroutineScope()
    DisposableEffect(Unit){
        val timer = Timer()
        timer.schedule(object:TimerTask(){
            override fun run() {
                coroutineScope.launch {
                    PaperState.animateScrollToPage(PaperState.currentPage + 1)
                }
            } },3000,3000)
        onDispose {
            timer.cancel()
        }
    }
    HorizontalPager(
        pageCount = VirtualPage,
        state = PaperState,
        modifier = Modifier
            .background(Color.Gray.copy(alpha = 0.2f))
            .padding(all = 8.dp)
            .clip(RoundedCornerShape(8.dp))
    ) { index ->
        val ActualIndex=index % ActualPage
        AsyncImage(
            model = vm.swipeData[ActualIndex].imageUrl,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(7 / 3f),
            contentScale = ContentScale.Crop
        )
    }
}

