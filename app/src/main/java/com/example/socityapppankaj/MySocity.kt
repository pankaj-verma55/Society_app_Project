package com.example.socityapppankaj

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.socityapppankaj.databinding.ActivityMySocityBinding

class MySocity : AppCompatActivity() {
    private lateinit var binding: ActivityMySocityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMySocityBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.link.setOnClickListener(View.OnClickListener {
            Toast.makeText(this@MySocity,"button Clicked", Toast.LENGTH_SHORT).show()
            val intent = Intent(Intent.ACTION_VIEW)
            intent.setData(Uri.parse("https://maps.app.goo.gl/N2QovW6bEYtB6p7r6"))
            startActivity(intent)
        })




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}