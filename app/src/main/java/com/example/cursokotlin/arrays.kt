package com.example.cursokotlin

fun main(){
    val weekDays = arrayOf("Lunes","Martes","Miercoles","Jueves","Viernes","Sábado","Domingo")

    for(position in weekDays.indices){
        println(position)
    }

    for((position, values) in weekDays.withIndex()){
        println("la posición $position contiene $values")
    }

    for(value in weekDays){
        println(value)
    }
}