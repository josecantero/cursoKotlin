package com.example.cursokotlin.TodoApp

data class Task(val name:String, val category:TaskCategory, var isSelected:Boolean = false) {
    fun render(task:Task) {}
}