package com.example.socityapppankaj

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.socityapppankaj.databinding.ActivityEmergencyBinding

class Emergency : AppCompatActivity() {
    private lateinit var binding: ActivityEmergencyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEmergencyBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.police.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@Emergency,"button Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:108"))
            startActivity(intent)
        })

        binding.ambulance.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@Emergency,"button Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:112"))
            startActivity(intent)
        })

        binding.fire.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@Emergency,"button Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:999"))
            startActivity(intent)
        })

        binding.watchman.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@Emergency,"button Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:9999999999"))
            startActivity(intent)
        })

        binding.secratory.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@Emergency,"button Clicked",Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:999999999"))
            startActivity(intent)
        })


//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }
    }
}