package com.example.cursokotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cursokotlin.Fapp.FappActivity
import com.example.cursokotlin.IMCCalculator.IMCAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val btnSaludapp = findViewById<Button>(R.id.btnSaludapp)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCapp)

        btnSaludapp.setOnClickListener{ navigateToSaludapp() }
        btnIMCApp.setOnClickListener{ navigateToIMCapp() }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun navigateToIMCapp() {
        val intent = Intent(this, IMCAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this,  FappActivity::class.java)
        startActivity(intent)
    }
}