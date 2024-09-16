package com.example.pokemonproject.network

import com.example.pokemonproject.data.model.PokemonDetail
import com.example.pokemonproject.data.model.Pokemon
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPokemons(): PokemonResponse

    // Método para obtener los detalles de un Pokémon por ID
    @GET("pokemon/{id}")
    suspend fun getPokemonDetail(@Path("id") id: Int): PokemonDetail
}

data class PokemonResponse(
    val results: List<Pokemon>
)