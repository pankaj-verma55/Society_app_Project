package com.example.socityapppankaj

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class MainVisitor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_visitor)


        val etInputData: EditText = findViewById(R.id.etInputData)
        val contactNumber : EditText = findViewById(R.id.contactNumber)
        val visitingWork : EditText = findViewById(R.id.visitingWork)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val inputData = etInputData.text.toString()
            val inputphone = contactNumber.text.toString()
            val inputvisitor = visitingWork.text.toString()

            if (inputData.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("EXTRA_INPUT_DATA", inputData)
                }
                startActivity(intent)
            }
            if (inputphone.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("EXTRA_INPUT_DATA", inputphone)
                }
                startActivity(intent)
            }
            if (inputvisitor.isNotEmpty()) {
                val intent = Intent(this, DisplayActivity::class.java).apply {
                    putExtra("EXTRA_INPUT_DATA", inputvisitor)
                }
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