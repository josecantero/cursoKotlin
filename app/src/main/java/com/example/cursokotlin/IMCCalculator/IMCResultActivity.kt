package com.example.cursokotlin.IMCCalculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cursokotlin.IMCCalculator.IMCAppActivity.Companion.IMCKEY
import com.example.cursokotlin.MenuActivity
import com.example.cursokotlin.R

class IMCResultActivity : AppCompatActivity() {
    private lateinit var tvIMCResultType:TextView
    private lateinit var tvIMCResultNumber:TextView
    private lateinit var tvIMCResultDescription:TextView
    private lateinit var btnRecalcular: Button
    private lateinit var btnGoMenu: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcresult)

        val result = intent.extras?.getDouble(IMCKEY)?:-1.0
        initComponents()
        initUI(result)
        initListeners()


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    private fun initComponents(){
        tvIMCResultType = findViewById(R.id.tvIMCResultType)
        tvIMCResultNumber = findViewById(R.id.tvIMCResultNumber)
        tvIMCResultDescription = findViewById(R.id.tvIMCResultDescription)
        btnRecalcular = findViewById(R.id.btnRecalcular)
        btnGoMenu = findViewById(R.id.btnGoMenu)
    }

    private fun initUI(result:Double){
        tvIMCResultNumber.text = result.toString()
        when(result){
            in 0.00..18.50 ->{
                tvIMCResultType.text = getString(R.string.lowWeight)
                tvIMCResultDescription.text = getString(R.string.lowWeightDescription)
            }
            in 18.51..24.99 ->{
                tvIMCResultType.text = getString(R.string.normal)
                tvIMCResultDescription.text = getString(R.string.normalDescription)
            }
            in 25.00..29.99 ->{
                tvIMCResultType.text = getString(R.string.overWeight)
                tvIMCResultDescription.text = getString(R.string.overWeightDescription)
            }
            in 30.00..99.00 ->{
                tvIMCResultType.text = getString(R.string.obesity)
                tvIMCResultDescription.text = getString(R.string.obesityDescription)
            }
            else -> {
                tvIMCResultType.text = getString(R.string.error)
                tvIMCResultNumber.text = getString(R.string.error)
            }
        }
    }

    private fun initListeners(){
        btnRecalcular.setOnClickListener{
            val intent = Intent(this, IMCAppActivity::class.java)
            startActivity(intent)
        }

        btnGoMenu.setOnClickListener{
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
        }
    }
}