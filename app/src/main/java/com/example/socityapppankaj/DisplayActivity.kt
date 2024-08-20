package com.example.socityapppankaj

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_display)


        val tvDisplayData: TextView = findViewById(R.id.tvDisplayData)
        val phnumber: TextView = findViewById(R.id.phnumber)
        val Vdetial: TextView = findViewById(R.id.Vdetial)

        val inputData = intent.getStringExtra("EXTRA_INPUT_DATA")
        tvDisplayData.text = inputData ?: "No data received"
        val inputPhone = intent.getStringExtra("EXTRA_INPUT_DATA")
        phnumber.text = inputPhone ?: "No data received"
        val inputVisitor = intent.getStringExtra("EXTRA_INPUT_DATA")
        Vdetial.text = inputVisitor ?: "No data received"

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}