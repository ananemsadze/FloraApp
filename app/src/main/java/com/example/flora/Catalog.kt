package com.example.flora

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_catalog.*

class Catalog : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalog)
        init()
    }

    private fun init() {
        shoppingCartIcon.setOnClickListener {
            val intent = Intent(this, ShoppingCart::class.java)
            startActivity(intent)
        }
        PeaceLilyCatalog.setOnClickListener {
            val intent = Intent(this, PeaceLilyPlant::class.java)
            startActivity(intent)
        }

        CrotonCatalog.setOnClickListener {
            val intent = Intent(this, CrotonPlant::class.java)
            startActivity(intent)
        }

        ScheffleraCatalog.setOnClickListener {
            val intent = Intent(this, ScheffleraArboricolaPlant::class.java)
            startActivity(intent)
        }
        MonsteraCatalog.setOnClickListener {
            val intent = Intent(this, MonsteraPlant::class.java)
            startActivity(intent)
        }
        PonytailPalmCatalog.setOnClickListener {
            val intent = Intent(this, PonytailPalmPlant::class.java)
            startActivity(intent)
        }
        SnakePlantCatalog.setOnClickListener {
            val intent = Intent(this, SnakePlant::class.java)
            startActivity(intent)
        }


    }





}