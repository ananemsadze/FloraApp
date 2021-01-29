package com.example.flora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_welcome_page.*

class welcomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_page)
        init()
    }

    private fun init(){
        StartShoppingButton.setOnClickListener(){
            val intent = Intent(this, Catalog::class.java)
            startActivity(intent)
        }
    }
}