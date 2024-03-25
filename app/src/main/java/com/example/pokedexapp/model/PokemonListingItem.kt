package com.example.pokedexapp.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListingItem(
    val name: String,
    val url: String
)
