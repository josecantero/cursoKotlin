package com.example.cursokotlin.ejercicios

fun main(){
    val morningNotificacion = 35
    val eveningNotificaion = 105

    printNotificacionSumary(morningNotificacion)
    printNotificacionSumary(eveningNotificaion)
}

fun printNotificacionSumary(notification:Int){
    when(notification){
        in 1..100 -> println("You have $notification notifications")
        else -> println("Your phone is blowing up, you have 99+ notificacions")
    }
}