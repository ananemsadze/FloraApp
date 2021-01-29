package com.example.flora

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_croton_plant.*
import kotlinx.android.synthetic.main.activity_croton_plant.AddToCartButton
import kotlinx.android.synthetic.main.activity_monstera_plant.*

class MonsteraPlant : AppCompatActivity() {
    private var changeButton = true
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_monstera_plant)
        init()
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        AddToCartButton.setOnClickListener {
            if (changeButton) {
                AddToCartButton.setText(R.string.add_to_cart)

            } else {
                AddToCartButton.setText(R.string.addedToCart)
                val monstera = "Monstera Deliciosa"
                val monsteraPrice = "39.95"
                val edit = sharedPreferences.edit()
                edit.putString("Monstera", monstera)
                edit.putString("MonsteraPrice", monsteraPrice)
                edit.apply()
                AddToCartButton.isClickable = false
            }
            changeButton = !changeButton
        }

    }

    fun backToCatalog(view: View) {
        val intent = Intent(this, Catalog::class.java)
        startActivity(intent)
    }
}