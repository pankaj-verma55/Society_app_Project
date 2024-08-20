package com.example.socityapppankaj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.socityapppankaj.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()

        binding.backbtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignInActivity, MainActivity::class.java)
            startActivity(intent)
        })
        binding.newRegisterSignIn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignInActivity, SignUpActivity::class.java)
            startActivity(intent)
        })


        binding.signInBtn.setOnClickListener(View.OnClickListener {
            val emails = binding.signInEmail.text.toString()
            val passwords = binding.signInPassword.text.toString()
            if (emails.isNotEmpty() && passwords.isNotEmpty()) {
                auth.signInWithEmailAndPassword(emails, passwords).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this@SignInActivity, "SignIn Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this@SignInActivity, HomeActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(applicationContext, "Wrong Email or Password", Toast.LENGTH_LONG).show()
                    }
                }
            }
            else {
                Toast.makeText(applicationContext, "Empty field are not allowed", Toast.LENGTH_LONG).show()
            }
        })
    }
}