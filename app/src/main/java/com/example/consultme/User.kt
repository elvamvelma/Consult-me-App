package com.example.consultme

class User {
    var name:String = ""
    var age:String = ""
    var gender:String = ""
    var email:String = ""
    var phone:String = ""
    var place:String = ""
    var id:String = ""

    constructor(name:String,age:String,gender:String,email:String,phone:String,place:String,id:String){
        this.name = name
        this.age = age
        this.gender = gender
        this.email = email
        this.phone = phone
        this.place = place
        this.id = id
    }

    constructor(){}
}