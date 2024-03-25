package com.example.pokedexapp.data

import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.network.PokemonApiService

class PokemonRepository(private val apiService: PokemonApiService) {
    suspend fun getPokemonDetails(name: String): PokemonDetails {
        return apiService.getPokemonDetails(name)
    }


}