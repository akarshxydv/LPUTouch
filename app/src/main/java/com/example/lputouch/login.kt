package com.example.lputouch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lputouch.databinding.ActivityLoginBinding

class login : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            val user=binding.editTextTextPersonName.text.toString().trim()
            val pass=binding.editTextTextPassword.text.toString().trim()
            if(user.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Please Enter user and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            startActivity(Intent(this,MainActivity::class.java))
        }

        binding.textView3.setOnClickListener(){
            startActivity(Intent(this,register::class.java))
        }

    }
}
