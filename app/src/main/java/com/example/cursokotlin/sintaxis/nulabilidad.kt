package com.example.cursokotlin.sintaxis

fun main(){
    val name:String?= null

    print(name?.get(3) ?: "es nulo cabrón! Espabila!")
}