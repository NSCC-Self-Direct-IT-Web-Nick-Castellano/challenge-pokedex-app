package com.example.pokedexapp.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonListingItem(
    val name: String,
    val url: String
)

@Serializable
data class PokemonListing(
    val count: Int,
    val next: String? = null,
    val previous: String? = null,
    val results: List<PokemonListingItem>
)