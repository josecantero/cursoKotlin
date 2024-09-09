package com.example.cursokotlin.sintaxis

fun main(){
    println(getTrimestre(2))
}

fun getMonth(month:Int){
    when(month){
        1 -> print("Enero")
        2 -> {
            println("febrero")
            println("se acabaron los meses")
        }
    }
}

fun getTrimestre(mes:Int): String{
    val result = when(mes){
        1,2,3 -> "primer trimestre"
        4,5,6 -> "segundo trimestre"
        else -> "no"
    }

    return result
}

fun getSemestre(num:Int){
    when(num){
        in 1..6 -> println("primer semestre")
        in 7..12 -> println("segundo semestre")
        !in 1..12 -> println("semestre no válido")
    }
}