package com.example.flora

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_croton_plant.*
import kotlinx.android.synthetic.main.activity_croton_plant.AddToCartButton
import kotlinx.android.synthetic.main.activity_snake_plant.*

class SnakePlant : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var changeButton = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snake_plant)
        init()
    }
    private fun init() {
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        AddToCartButton.setOnClickListener {
            if (changeButton) {
                AddToCartButton.setText(R.string.add_to_cart)

            } else {
                AddToCartButton.setText(R.string.addedToCart)
                val snakeplant = "Snake Plant"
                val snakePlantPrice = "35.29"
                val edit = sharedPreferences.edit()
                edit.putString("SnakePlant", snakeplant)
                edit.putString("SnakePlantPrice", snakePlantPrice)
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