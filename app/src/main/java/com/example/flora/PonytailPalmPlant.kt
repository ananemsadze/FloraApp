package com.example.flora

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_croton_plant.*
import kotlinx.android.synthetic.main.activity_croton_plant.AddToCartButton
import kotlinx.android.synthetic.main.activity_ponytail_palm_plant.*

class PonytailPalmPlant : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private var changeButton = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ponytail_palm_plant)
        init()
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        AddToCartButton.setOnClickListener {
            if (changeButton) {
                AddToCartButton.setText(R.string.add_to_cart)

            } else {
                AddToCartButton.setText(R.string.addedToCart)
                val ponytailpalm = "Ponytail Palm"
                val ponytailPalmPrice = "39.95"
                val edit = sharedPreferences.edit()
                edit.putString("PonytailPalm", ponytailpalm)
                edit.putString("PonytailPalmPrice", ponytailPalmPrice)
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