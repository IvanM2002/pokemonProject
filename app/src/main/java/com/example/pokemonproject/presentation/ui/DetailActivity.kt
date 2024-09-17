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
        val pokemonHeight = intent.getIntExtra("pokemon_height", 0)
        val pokemonWeight = intent.getIntExtra("pokemon_weight", 0)
        val pokemonTypes = intent.getStringArrayListExtra("pokemon_types")
        val pokemonAbilities = intent.getStringArrayListExtra("pokemon_abilities")
        val pokemonStats = intent.getStringArrayListExtra("pokemon_stats")

        // Asignar valores a las vistas
        findViewById<TextView>(R.id.pokemon_name).text = pokemonName
        findViewById<TextView>(R.id.pokemon_height).text = "Height: $pokemonHeight"
        findViewById<TextView>(R.id.pokemon_weight).text = "Weight: $pokemonWeight"
        findViewById<TextView>(R.id.pokemon_types).text = "Types: ${pokemonTypes?.joinToString(", ")}"
        findViewById<TextView>(R.id.pokemon_abilities).text = "Abilities: ${pokemonAbilities?.joinToString(", ")}"
        findViewById<TextView>(R.id.pokemon_stats).text = "Stats: ${pokemonStats?.joinToString(", ")}"

        // Cargar imagen con Glide
        Glide.with(this)
            .load(pokemonImage)
            .into(findViewById(R.id.pokemon_image))
    }
}