package com.example.pokemonproject.presentation.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.pokemonproject.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val pokemonName = intent.getStringExtra("pokemon_name")
        val pokemonImage = intent.getStringExtra("pokemon_image")

        findViewById<TextView>(R.id.pokemon_name).text = pokemonName
        Glide.with(this).load(pokemonImage).into(findViewById(R.id.pokemon_image))
    }
}