package com.example.cursokotlin.IMCCalculator

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.cursokotlin.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCAppActivity : AppCompatActivity() {
    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnSubsWeight: FloatingActionButton
    private lateinit var btnAddWeight:FloatingActionButton
    private lateinit var btnSubsAge:FloatingActionButton
    private lateinit var btnAddAge:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var tvAge:TextView

    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    private var currentWeight:Int = 60
    private var currentAge:Int = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcapp)

        initComponents()
        initListeners()
        initUI()


        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.leftCard)
        viewFemale = findViewById(R.id.rightCard)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubsWeight = findViewById(R.id.btnSubsWeight)
        btnAddWeight = findViewById(R.id.btnAddWeight)
        btnSubsAge = findViewById(R.id.btnSubsAge)
        btnAddAge = findViewById(R.id.btnAddAge)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
    }

    @SuppressLint("SetTextI18n")
    private fun initListeners(){
        viewMale.setOnClickListener{
            changeGenderState()
            setCardColor()
        }
        viewFemale.setOnClickListener{
            changeGenderState()
            setCardColor()
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")

            tvHeight.text = "${df.format(value)} cm"
        }

        btnSubsWeight.setOnClickListener{
            currentWeight -= 1
            setWeight()
        }

        btnAddWeight.setOnClickListener {
            currentWeight += 1
            setWeight()
        }

        btnSubsAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }

        btnAddAge.setOnClickListener {
            currentAge += 1
            setAge()
        }

    }

    private fun setWeight(){
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    private fun changeGenderState(){
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected

    }

    private fun setCardColor(){
        viewMale.setCardBackgroundColor(getBackGroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackGroundColor(isFemaleSelected))
    }

    private fun getBackGroundColor(isSelectedComponent:Boolean):Int{
        val colorReference = if(isSelectedComponent){
            R.color.Background_component_selected
        }else{
            R.color.Background_component
        }

        return colorReference
    }

    private fun initUI() {
        setCardColor()
        setWeight()
        setAge()
    }


}