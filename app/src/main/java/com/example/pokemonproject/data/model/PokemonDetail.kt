package com.example.pokemonproject.data.model

import com.google.gson.annotations.SerializedName

data class PokemonDetail(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val sprites: Sprites,
    val types: List<Type>,
    val abilities: List<Ability>,
    val stats: List<Stat>
)

data  class Sprites(
    @SerializedName("front_default") val frontDefault: String?
)

data class Type(
    val slot: Int,
    val type: TypeDetail
)

data class TypeDetail(
    val name: String,
    val url: String
)

data class Ability(
    val ability: AbilityDetail,
    @SerializedName("is_hidden") val isHidden: Boolean,
    val slot: Int
)

data class AbilityDetail(
    val name: String,
    val url: String
)

data class Stat(
    @SerializedName("base_stat") val baseStat: Int,
    val effort: Int,
    val stat: StatDetail
)

data class StatDetail(
    val name: String,
    val url: String
)