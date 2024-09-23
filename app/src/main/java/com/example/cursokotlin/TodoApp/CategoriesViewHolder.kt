package com.example.cursokotlin.TodoApp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R

class CategoriesViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView =  view.findViewById(R.id.tvCategoryName)
    private val vDivider:View = view.findViewById(R.id.vDivider)
    fun render(taskCategory: TaskCategory){
        when(taskCategory){
            TaskCategory.Bussines -> {
                tvCategoryName.text = "Negocios"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_business)
                )
            }
            TaskCategory.other -> {
                tvCategoryName.text = "Otro"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_other)
                )
            }
            TaskCategory.personal -> {
                tvCategoryName.text = "Personal"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_personal)
                )
            }
        }
    }
}