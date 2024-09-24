package com.example.cursokotlin.TodoApp

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cursokotlin.R
import com.example.cursokotlin.TodoApp.TaskCategory.*
import com.example.cursokotlin.TodoApp.TaskAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        personal,
        Bussines,
        other
    )

    private val tasks = mutableListOf(
        Task("PreubaBusiness", Bussines),
        Task("PreubaPersonal", personal),
        Task("PreubaOtro", other)
    )

    // COMPONENTS
    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var rvTasks:RecyclerView
    private lateinit var taskAdapter:TaskAdapter
    private lateinit var btnTodoAddTask: FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_todo)

        initComponents()
        initUI()
        initListeners()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun initComponents(){
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        btnTodoAddTask = findViewById(R.id.btnTodoAddTask)

    }

    private fun initListeners(){
        btnTodoAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
        val btnDialogAddTask: AppCompatButton = dialog.findViewById(R.id.btnDialogAddTask)
        val etTask:EditText = dialog.findViewById(R.id.etTask)
        val rgCategories:RadioGroup = dialog.findViewById(R.id.rgCategories)

        btnDialogAddTask.setOnClickListener {
            val rbSelected = rgCategories.checkedRadioButtonId
            val selectedRadioButtom:RadioButton = rgCategories.findViewById(rbSelected)
            val currentCategory:TaskCategory = when(selectedRadioButtom.text){
                "Negocios" -> Bussines
                "Personal" -> personal
                else -> other
            }
            tasks.add(Task(etTask.text.toString(), currentCategory))
            updateTask()
            dialog.hide()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTask(){
        taskAdapter.notifyDataSetChanged()
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories)
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks)
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter
    }
}