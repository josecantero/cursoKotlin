package com.example.cursokotlin.sintaxis

fun main(){

    //inmutableList()
    mutableList()


}

fun inmutableList(){
    //lista inmutable
    val nombres:List<String> = listOf("Manolo","Ricardo", "Domingo")

    println(nombres.first())
    println(nombres.last())
    println(nombres.filter{nombre ->nombre.contains("a")})

    nombres.forEach {nombre -> (println(nombre)) }
}

fun mutableList(){
    val nombres:MutableList<String> = mutableListOf("Antonio", "Leonarodo", "María")
    nombres.add("Lilian")
    nombres.add(0,"Elena")
    nombres.remove("Antonio")
    nombres.forEach{nombre -> println(nombre)}
}