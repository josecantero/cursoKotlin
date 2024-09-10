package com.example.cursokotlin.Fapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cursokotlin.R

class FappActivity : AppCompatActivity() {
    //método que se llama al arrancar la app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_fapp)
        val editText = findViewById<AppCompatEditText>(R.id.editText)
        val btnPulsar = findViewById<AppCompatButton>(R.id.btnPulsar)


        btnPulsar.setOnClickListener{
            val nameText = editText.text.toString()
            if(nameText.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("extraName", nameText)
                startActivity(intent)
            }

        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}