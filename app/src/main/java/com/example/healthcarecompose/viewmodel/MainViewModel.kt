package com.example.healthcarecompose.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.healthcarecompose.model.entity.Category
import com.example.healthcarecompose.model.entity.SwipePicture

class MainViewModel: ViewModel() {
    //分类数据
    val categories by mutableStateOf(listOf(Category("热门服务"),
        Category("婴儿护理"),
        Category("照顾父母"),
        Category("呵护家人"),
        Category("中医护理")))
    //选择的分类下标
    var categoryIndex by mutableStateOf(0)
        private set
    //更新下标
    fun updateCategoryIndex(index: Int){
        categoryIndex=index
    }
    //服务数据

    //当前页
    var currentNavigationIndex by mutableStateOf(0)
     private set
    fun set_currentNavigationIndex(index:Int){
        currentNavigationIndex=index
    }

    //轮播图数据
    val swipeData = listOf(
        SwipePicture("https://wx1.sinaimg.cn/mw690/4418fa2bly1hcx1bcjxaej20rs0k2ae3.jpg"),
        SwipePicture("https://wx3.sinaimg.cn/mw690/738d919cgy1hcw451399bj20u00kvaef.jpg"),
        SwipePicture("https://wx2.sinaimg.cn/mw690/008uAYX8ly1hcv0fk8tqsj30b207daam.jpg"),
        SwipePicture("https://wx4.sinaimg.cn/mw690/639b1bfbly1hcx1j9ugwtj20e30cxwhv.jpg")
    )
}