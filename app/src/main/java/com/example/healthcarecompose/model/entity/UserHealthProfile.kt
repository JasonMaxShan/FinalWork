package com.example.healthcarecompose.model.entity

data class UserHealthProfile(
    val ID:String,
    var name:String,
    var Sex:String,
    var BirthDate:String,
    var Height:Double,
    var Weight:Double,
    var Nation:String,
    var BloodType:String,
    var RH:String,
    var EduLevel:String,
    var PeopleType:String,
    var Allergy_history:String,
    var Family_history:String,
    var Previous_history:String
)
