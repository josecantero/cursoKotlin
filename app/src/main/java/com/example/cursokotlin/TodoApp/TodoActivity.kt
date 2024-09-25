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
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {

    private val categories = listOf(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf(
        Task("PreubaBusiness", Business),
        Task("PreubaPersonal", Personal),
        Task("PreubaOtro", Other)
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
            if(etTask.text.toString().isNotEmpty()) {

                val rbSelected = rgCategories.checkedRadioButtonId
                val selectedRadioButtom: RadioButton = rgCategories.findViewById(rbSelected)
                val currentCategory: TaskCategory = when (selectedRadioButtom.text) {
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_Personal) -> Personal
                    else -> Other

                }
                tasks.add(Task(etTask.text.toString(), currentCategory))
                updateTask()
                dialog.hide()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateTask(){
        val selectedCategories:List<TaskCategory> = categories.filter{ it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter.task = newTasks
        taskAdapter.notifyDataSetChanged()
    }

    private fun initUI(){
        categoriesAdapter = CategoriesAdapter(categories) {position -> updateCategories(position)}
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks) {position -> onItemSelected(position)}
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter
    }

    private fun updateCategories(postion: Int){
        categories[postion].isSelected = !categories[postion].isSelected
        categoriesAdapter.notifyItemChanged(postion)
        updateTask()
    }

    private fun onItemSelected(postion: Int){
        tasks[postion].isSelected = !tasks[postion].isSelected
        updateTask()
    }
}