package com.example.cursokotlin

fun main(){
    val name:String?= null

    print(name?.get(3) ?: "es nulo cabrón! Espabila!")
}