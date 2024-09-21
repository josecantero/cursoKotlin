package com.example.cursokotlin.TodoApp

sealed class TaskCategory {
    object personal:TaskCategory()
    object Bussines:TaskCategory()
    object other:TaskCategory()
}