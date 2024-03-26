package com.example.pokedexapp.network

import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.model.PokemonListing
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetails

    // for getting pokemons with pagination
    @GET("pokemon/{name}")
    suspend fun getPokemonDetailsWithPagination(@Path("name") name: String): PokemonDetails

    @GET("pokemon/?offset={offset}&limit={limit}")
    suspend fun getPokemonListing(@Path("offset") offset: Int, @Path("limit") limit: Int): PokemonListing
}

//
//fun createPokemonApiService(): PokemonApiService {
//    val BASE_URL = "https://pokeapi.co/api/v2/"
//
//    val retrofit = Retrofit.Builder()
//        .addConverterFactory(kotlinx.serialization.json.Json.asConverterFactory("application/json".toMediaType()))
//        .baseUrl(BASE_URL)
//        .build()
//
//    return retrofit.create(PokemonApiService::class.java)
//}