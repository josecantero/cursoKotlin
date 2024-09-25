package com.example.cursokotlin.TodoApp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R

class CategoriesViewHolder(view:View):RecyclerView.ViewHolder(view) {
    private val tvCategoryName: TextView =  view.findViewById(R.id.tvCategoryName)
    private val vDivider:View = view.findViewById(R.id.vDivider)
    private val cvCategoryViewContainer:CardView = view.findViewById(R.id.cvCategoryViewContainer)

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit){
        val color = if(taskCategory.isSelected){
            R.color.card_todo
        }else{
            R.color.purple_200
        }

        cvCategoryViewContainer.setCardBackgroundColor(ContextCompat.getColor(cvCategoryViewContainer.context, color))

        itemView.setOnClickListener{ onItemSelected(layoutPosition) }

        when(taskCategory){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_business)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Otro"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_other)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                vDivider.setBackgroundColor(
                    ContextCompat.getColor(vDivider.context, R.color.todo_personal)
                )
            }
        }
    }
}