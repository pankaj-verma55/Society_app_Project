package com.example.socityapppankaj


import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.socityapppankaj.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.alarm.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,Awaz::class.java)
            startActivity(intent)
        })

        binding.event.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,EventOrganisation::class.java)
            startActivity(intent)
        })

        binding.visitorperson.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,MainVisitor::class.java)
            startActivity(intent)
        })

        binding.maintainance.setOnClickListener {
            val intent = Intent(this@HomeActivity, MaintainanceActivity::class.java)
            startActivity(intent)
        }

        binding.anouncement.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,Anouncement::class.java)
            startActivity(intent)
        })
        binding.noticeBoard.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,NoticeBoard::class.java)
            startActivity(intent)
        })
        binding.mySocity.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,MySocity::class.java)
            startActivity(intent)
        })
        binding.help.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@HomeActivity,Emergency::class.java)
            startActivity(intent)
        })



//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }











    }
}