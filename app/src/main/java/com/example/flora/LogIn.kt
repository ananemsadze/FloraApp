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
import kotlinx.android.synthetic.main.activity_log_in.*
import kotlinx.android.synthetic.main.sign_up.*

class LogIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        init()
    }


    private fun init(){

        auth = Firebase.auth
        logInButton.setOnClickListener(){
            logIn()
        }
    }

    private fun emailChecker () {
        if (emailEditText.text.toString().isNotEmpty()) {
            if (android.util.Patterns.EMAIL_ADDRESS.matcher(emailEditText.text.toString()).matches())
            else {
                emailEditText.setError("Email format is not correct")
            }
        }
    }

    private fun logIn(){
        emailChecker()
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        if(email.isNotEmpty() && password.isNotEmpty()){
            logInButton.isClickable = false
            progressBar.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Log.d("signIn", "signInWithEmail:success")
                        val user = auth.currentUser
                        progressBar.visibility = View.VISIBLE
                        val intent = Intent(this, Catalog::class.java)
                        startActivity(intent)
                    } else {
                        Log.d("signIn", "signInWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
                        progressBar.visibility = View.VISIBLE
                    }
                }
        }else{
            Toast.makeText(this, "There is no user with this email or password", Toast.LENGTH_SHORT).show()
        }
    }


}