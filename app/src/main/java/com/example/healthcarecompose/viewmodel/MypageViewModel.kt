package com.example.healthcarecompose.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.lifecycle.ViewModel
import com.example.healthcarecompose.model.entity.AccountOrderItem
import com.example.healthcarecompose.model.entity.UserAddressEntity
import com.example.healthcarecompose.model.entity.UserHealthProfile

class MypageViewModel:ViewModel() {
    val OtherService= listOf(
        AccountOrderItem("我的账户",icon=Icons.Filled.Person,""),
        AccountOrderItem("我的地址", icon = Icons.Filled.LocationOn,""),
        AccountOrderItem("健康档案",icon=Icons.Filled.Accessibility,""),
        AccountOrderItem("联系客服",icon=Icons.Filled.SupportAgent,""),
    )
    //联系客服界面
    data class data(
        val name:String,
        val type:String,
    )

    val ContectType= listOf(
        data("账户问题","account_problem"),
        data("账单问题","order_problem"),
        data("其他问题","other_problem")
    )

    data class problem_sent(
        var type:String,
        var detail: String,
        var other: String,
    )

    var problem=problem_sent("","","")
    private set

    fun set_problem(type:String, detail: String, other: String){
        problem.type=type
        problem.detail=detail
        if (other==null){
            problem.other==null
        }else{
            problem.other=other
        }
    }
    //健康档案界面
    val BloodType= listOf(
        data("A","A"),
        data("B","B"),
        data("O","O"),
        data("AB","AB"),
        data("不详","Unknown")
    )
    val RH_negative = listOf(
        data("是","true"),
        data("否","false"),
        data("未知","Unknown")
    )
    val Educational_level = listOf(
        data("从未上过学","none"),
        data("小学","primary"),
        data("初中","middle"),
        data("中专/高中","senior"),
        data("大专/本科及以上","college")
    )
    val People_type = listOf(
        data("健康","healthy"),
        data("孕产妇","pregnant"),
        data("儿童","children"),
        data("育龄妇女","childbearing_age"),
        data("60岁以上老人","old"),
        data("残疾","disabled"),
        data("精神障碍","mental_disorders"),
        data("高血压","hypertension"),
        data("糖尿病","diabetes"),
        data("其他","other"),
    )
    val smoke= listOf(
        data("无","false"),
        data("有","true")
    )
    val alcohol= listOf(
        data("无","false"),
        data("有","true")
    )
    var user_profile=UserHealthProfile(
        "1",
        "SZP",
        "男",
        "1999-10-28",
        165.0,
        70.0,
        "汉",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
    )
    private set
    fun set_user_profile(
         ID:String,
         name:String,
         Sex:String,
         BirthDate:String,
         Height:Double,
         Weight:Double,
         Nation:String,
         BloodType:String,
         RH:String,
         EduLevel:String,
         PeopleType:String,
         Allergy_history:String,
         Family_history:String,
         Previous_history:String
    ){
        user_profile.name=name
        user_profile.Sex=Sex
        user_profile.BirthDate=BirthDate
        user_profile.Height=Height
        user_profile.Weight=Weight
        user_profile.Nation=Nation
        user_profile.BloodType=BloodType
        user_profile.RH=RH
        user_profile.EduLevel=EduLevel
        user_profile.PeopleType=PeopleType
        user_profile.Allergy_history=Allergy_history
        user_profile.Family_history=Family_history
        user_profile.Previous_history=Previous_history
    }
    //地址界面

    var user_address=UserAddressEntity("1","浙江","宁波","海曙","ABSS")
    private set
    fun set_user_address(
        province:String,
        city:String,
        distinct:String,
        add:String
    ){
        user_address.province=province
        user_address.city=city
        user_address.distinct=distinct
        user_address.add=add
    }
}