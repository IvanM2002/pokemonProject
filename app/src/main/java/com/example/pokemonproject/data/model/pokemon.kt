package com.example.pokemonproject.data.model

import com.google.gson.annotations.SerializedName

data class Pokemon(
    val name: String,
    @SerializedName("url") val url: String
) {
    val id: Int
        get() = url.split("/").filter { it.isNotEmpty() }.last().toInt()
}
