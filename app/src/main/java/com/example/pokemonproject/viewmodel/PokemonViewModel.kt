package com.example.pokemonproject.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonproject.data.model.Pokemon
import com.example.pokemonproject.data.model.PokemonDetail
import com.example.pokemonproject.data.repository.PokemonRepository
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {

    private val repository = PokemonRepository()

    // LiveData para observar la lista de Pokémon
    val pokemonList = MutableLiveData<List<Pokemon>?>()

    // Función para obtener la lista de Pokémon
    fun fetchPokemons() {
        viewModelScope.launch {
            try {
                // Obtener la lista de Pokémon desde el repositorio
                val pokemons = repository.getPokemons()
                // Publicar los datos en el LiveData
                pokemonList.postValue(pokemons)
            } catch (e: Exception) {
                // Manejar errores, si es necesario
                pokemonList.postValue(null)
            }
        }
    }

    // Función para obtener los detalles de un Pokémon por ID
    fun getPokemonDetails(id: Int, onResult: (PokemonDetail) -> Unit) {
        viewModelScope.launch {
            try {
                // Obtener los detalles del Pokémon desde el repositorio
                val pokemonDetail = repository.getPokemonDetails(id)
                // Retornar el resultado a través del callback
                onResult(pokemonDetail)
            } catch (e: Exception) {
                // Manejar errores
            }
        }
    }
}