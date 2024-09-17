package com.example.pokemonproject.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokemonproject.R
import com.example.pokemonproject.viewmodel.PokemonViewModel
import com.example.pokemonproject.presentation.adapter.PokemonAdapter

class PokemonListActivity : AppCompatActivity() {

    private val viewModel: PokemonViewModel by viewModels()
    private lateinit var adapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = PokemonAdapter(listOf()) { selectedPokemon ->
            val pokemonId = selectedPokemon.id

            viewModel.getPokemonDetails(pokemonId) { pokemonDetail ->
                if (pokemonDetail != null) {
                    val intent = Intent(this, DetailActivity::class.java).apply {
                        putExtra("pokemon_name", pokemonDetail.name)
                        putExtra("pokemon_image", pokemonDetail.sprites.frontDefault)
                        putExtra("pokemon_height", pokemonDetail.height)
                        putExtra("pokemon_weight", pokemonDetail.weight)

                        val types = pokemonDetail.types.map { it.type.name }
                        putStringArrayListExtra("pokemon_types", ArrayList(types))

                        val abilities = pokemonDetail.abilities.map { it.ability.name }
                        putStringArrayListExtra("pokemon_abilities", ArrayList(abilities))

                        val stats = pokemonDetail.stats.map { "${it.stat.name}: ${it.baseStat}" }
                        putStringArrayListExtra("pokemon_stats", ArrayList(stats))
                    }
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Failed to fetch Pokémon details", Toast.LENGTH_SHORT).show()
                }
            }
        }

        recyclerView.adapter = adapter

        viewModel.pokemonList.observe(this, Observer { pokemons ->
            if (pokemons != null) {
                adapter.updateList(pokemons)
            } else {
                Toast.makeText(this, "Failed to fetch Pokémon data", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.fetchPokemons()
    }
}