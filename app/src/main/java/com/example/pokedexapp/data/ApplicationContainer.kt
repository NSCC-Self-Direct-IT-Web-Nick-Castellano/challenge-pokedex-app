package com.example.pokedexapp.data

import com.example.pokedexapp.network.PokemonApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface ApplicationContainer {
    val pokemonRepository : PokemonRepository
}

/**
 * This class initiate a container that holds all the repository functions that the app
 * will use, such as fetch data repositories and api service providers and that sort
 */
class DefaultApplicationContainer : ApplicationContainer {
    // initiate our repository using base url
    private val BASE_URL = "https://pokeapi.co/api/v2/"

    // initiate the retrofit builder
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    // initiate api service
    private val retrofitService : PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)
    }

    override val pokemonRepository: PokemonRepository by lazy {
        NetworkPokemonRepository(retrofitService)
    }


}