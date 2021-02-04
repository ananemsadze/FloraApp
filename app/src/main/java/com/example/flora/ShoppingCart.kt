package com.example.flora

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_cart.*

class ShoppingCart : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_cart)
        init()
    }

    fun backToCatalog(view: View) {
        val intent = Intent(this, Catalog::class.java)
        startActivity(intent)
    }

    private fun init() {
        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)
        CatalogPlants()
        catalogPrice()


        BuyButton.setOnClickListener() {
            if (PlantNames.text.isNotEmpty() && PriceTags.text.isNotEmpty()) {
                val intent = Intent(this, LastPage::class.java)
                startActivity(intent)
                val edit = sharedPreferences.edit()
                edit.clear()
                edit.apply()

            } else {
                BuyButton.isClickable = false
            }
        }

    }

    @SuppressLint("SetTextI18n")
    fun CatalogPlants() {
        val croton = sharedPreferences.getString("Croton", "")
        val monstera = sharedPreferences.getString("Monstera", "")
        val peacelily = sharedPreferences.getString("PeaceLily", "")
        val ponytailpalm = sharedPreferences.getString("PonytailPalm", "")
        val schefflera = sharedPreferences.getString("ScheffleraArboricola", "")
        val snakeplant = sharedPreferences.getString("SnakePlant", "")


        PlantNames.text = croton + "\n" + monstera + "\n" + peacelily + "\n" + ponytailpalm +
                "\n" + schefflera + "\n" + snakeplant


    }

    @SuppressLint("SetTextI18n")
    fun catalogPrice() {

        val crotonPrice = sharedPreferences.getString("CrotonPrice", "0")
        val monsteraPrice = sharedPreferences.getString("MonsteraPrice", "0")
        val peaceLilyPrice = sharedPreferences.getString("PeaceLilyPrice", "0")
        val ponytailPalmPrice = sharedPreferences.getString("PonytailPalmPrice", "0")
        val scheffleraPrice = sharedPreferences.getString("ScheffleraPrice", "0")
        val snakePlantPrice = sharedPreferences.getString("SnakePlantPrice", "0")
        val crotonPricenumber = sharedPreferences.getString("CrotonPrice", "")
        val monsteraPricenumber = sharedPreferences.getString("MonsteraPrice", "")
        val peaceLilyPricenumber = sharedPreferences.getString("PeaceLilyPrice", "")
        val ponytailPalmPricenumber = sharedPreferences.getString("PonytailPalmPrice", "")
        val scheffleraPricenumber = sharedPreferences.getString("ScheffleraPrice", "")
        val snakePlantPricenumber = sharedPreferences.getString("SnakePlantPrice", "")


        PriceTags.text = crotonPricenumber + "\n" + monsteraPricenumber + "\n" + peaceLilyPricenumber +
                "\n" + ponytailPalmPricenumber + "\n" + scheffleraPricenumber + "\n" + snakePlantPricenumber



                val subtotal = crotonPrice.toString().toDouble() + monsteraPrice.toString().toDouble() +
                peaceLilyPrice.toString().toDouble()  + ponytailPalmPrice.toString().toDouble() +
                scheffleraPrice.toString().toDouble() + snakePlantPrice.toString().toDouble()

        totalPriceTextView.text = subtotal.toString()



    }


}