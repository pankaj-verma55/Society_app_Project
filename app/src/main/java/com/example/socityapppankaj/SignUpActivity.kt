package com.example.socityapppankaj

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.socityapppankaj.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth=FirebaseAuth.getInstance()

        binding.alredyRegisterText.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@SignUpActivity, SignInActivity::class.java)
            startActivity(intent)
        })
        binding.backbtn.setOnClickListener(View.OnClickListener {
            val intent= Intent(this@SignUpActivity,MainActivity::class.java)
            startActivity(intent)
        })
        binding.SignUpBtn.setOnClickListener(View.OnClickListener {
            val name = binding.signupName.text.toString()
            val email = binding.signUpEmail.text.toString()
            val password = binding.signupPassword.text.toString()
            val confirmpassword = binding.signUpconfirmPassword.text.toString()
            if(name.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmpassword.isNotEmpty()) {
                if (password == confirmpassword) {
                    auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                        if(it.isSuccessful) {
                            Toast.makeText(this@SignUpActivity, "SignUp Successful", Toast.LENGTH_LONG).show()
                            val intent = Intent(this@SignUpActivity, HomeActivity::class.java)
                            startActivity(intent)
                        }
                        else {
                            Toast.makeText(this@SignUpActivity, "Already Register", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                else {
                    Toast.makeText(this@SignUpActivity, "Wrong Email or Password", Toast.LENGTH_LONG).show()
                }
            }
            else {
                    Toast.makeText(this@SignUpActivity,"Empty field are not allowed",Toast.LENGTH_LONG).show()
                }
        })


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}