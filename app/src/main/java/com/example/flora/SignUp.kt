package com.example.flora

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.sign_up.*

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)
        init()


    }

    private fun init() {
        auth = Firebase.auth
        SignUpButton.setOnClickListener(){
            signup()
        }




    }

    private fun emailchecker() {
        if (EmailEnter.text.toString().isNotEmpty()) {
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(EmailEnter.text.toString()).matches())
            else {
                EmailEnter.setError("Email format is not correct")
            }
        }
    }


    private fun signup() {
        emailchecker()
        lengthcheck()
        val email = EmailEnter.text.toString()
        val password = PasswordEnter.text.toString()
        val repeatpassword = RepeatPassword.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty() && repeatpassword.isNotEmpty()) {
            if (password == repeatpassword) {
                SignUpButton.isClickable = false
                progressbar.visibility = View.VISIBLE
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        SignUpButton.isClickable = true
                        progressbar.visibility = View.GONE
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("signup", "createUserWithEmail:success")
                            progressbar.visibility = View.GONE
                                val intent = Intent(this, welcomePage::class.java)
                                startActivity(intent)

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.d("signup", "createUserWithEmail:failure", task.exception)
                            Toast.makeText(
                                baseContext, "Authentication failed",
                                Toast.LENGTH_SHORT
                            ).show()
                            progressbar.visibility = View.GONE
                        }
                    }
            } else {
                RepeatPassword.setError("Passwords don't match")
            }
        } else {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun lengthcheck() {
        val passwordlength = PasswordEnter.text.toString().length
        val passwordrepeatlength = RepeatPassword.text.toString().length
        if (passwordlength < 6 && passwordrepeatlength < 6) {
            PasswordEnter.setError("Password should be at least 6 characters")
        }
    }




}