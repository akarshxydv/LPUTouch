package com.example.lputouch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.lputouch.databinding.ActivityLoginBinding
import com.example.lputouch.databinding.ActivityRegisterBinding

class register : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.alreadyAcc.setOnClickListener(){
            startActivity(Intent(this,login::class.java))
        }

        binding.register.setOnClickListener(){
            val firstName=binding.firstname.text.toString().trim()
            val lastName=binding.lastname.text.toString().trim()
            val user=binding.user.text.toString().trim()
            val email=binding.email.text.toString().trim()
            val pass=binding.regPassword.text.toString().trim()
            val conpass=binding.confirmPassword.text.toString().trim()
            if(firstName.isEmpty()||lastName.isEmpty()||user.isEmpty()||email.isEmpty()||pass.isEmpty()||conpass.isEmpty()){
                Toast.makeText(this,"Enter all detail", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }else {

                if (pass != conpass) {
                    Toast.makeText(this, "Password do not match!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                } else {
                    if (isvalidEmail(email) && isvalidPass(pass)) {
                        Toast.makeText(this, "Register Successfully", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, login::class.java))
                    } else {
                        Toast.makeText(
                            this,
                            "Email and Password format are invalid",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
        }

    }
    private fun isvalidEmail(email:String):Boolean{
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isvalidPass(pass:String):Boolean{
        return pass.length>=8
    }
}
