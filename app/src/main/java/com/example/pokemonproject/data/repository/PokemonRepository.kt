package com.example.pokemonproject.data.repository

import com.example.pokemonproject.data.model.Pokemon
import com.example.pokemonproject.data.model.PokemonDetail
import com.example.pokemonproject.network.RetrofitInstance

class PokemonRepository {

    private val apiService = RetrofitInstance.api

    suspend fun getPokemons(): List<Pokemon> {
        return apiService.getPokemons().results
    }

    suspend fun getPokemonDetails(id: Int): PokemonDetail {
        return RetrofitInstance.api.getPokemonDetail(id)
    }
}