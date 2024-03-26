package com.example.pokedexapp.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonDetails(
    val id: Int,
    val name: String,
    @SerialName("base_experience")
    val baseExperience: Int,
    @SerialName("is_default")
    val isDefault: Boolean,
    val order: Int,
    val weight: Int,
    val height: Int,
    val types: List<PokemonType>,
    val sprites: Sprites,
)

@Serializable
data class Sprites(
    val front_default: String?,
    val back_default: String?
)

@Serializable
data class PokemonType(
    val slot: Int,
    val type: NamedAPIResource
)

@Serializable
data class NamedAPIResource(
    val name: String,
    val url: String
)