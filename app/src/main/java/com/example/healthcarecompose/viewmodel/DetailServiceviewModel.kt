package com.example.healthcarecompose.viewmodel

import androidx.lifecycle.ViewModel

class DetailServiceviewModel:ViewModel() {
    data class DetailService(
        val ServiceID:String,
        val Describe:String,
        val Remind:String,
    )

    val example= listOf(
        DetailService("1","用户必须具备正规医疗机构开具的处方、药品及病历证明；\n" +
                "护士只提供上门打针服务，不提供相关药品；\n" +
                "年龄不满3岁者不提供上门服务；\n" +
                "套餐内次数，有效期为1年。\n" +
                "一次性购买数量越多，优惠越多。","本服务为肌肉注射和皮下注射，不提供输液服务；\n" +
                "请确认患者对使用药品无过敏现象；\n" +
                "有严重出、凝血倾向，血小板明显减少或用肝素、双香豆素等进行抗凝治疗暂禁穿刺的患者不适宜上门打针服务；\n" +
                "一个订单一个地址只服务一针，多增加一针需要下新订单。"),
        DetailService("2","用户必须具备正规医疗机构开具的处方、药品及病历证明；\n" +
                "护士只提供上门打针服务，不提供相关药品；\n" +
                "年龄不满3岁者不提供上门服务；\n" +
                "套餐内次数，有效期为1年。\n" +
                "一次性购买数量越多，优惠越多。","本服务为肌肉注射和皮下注射，不提供输液服务；\n" +
                "请确认患者对使用药品无过敏现象；\n" +
                "有严重出、凝血倾向，血小板明显减少或用肝素、双香豆素等进行抗凝治疗暂禁穿刺的患者不适宜上门打针服务；\n" +
                "一个订单一个地址只服务一针，多增加一针需要下新订单。"),
    )

    val IDlist = example.map { it.ServiceID }
}