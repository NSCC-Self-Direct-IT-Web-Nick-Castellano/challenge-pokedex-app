package com.example.pokedexapp.network

import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.model.PokemonListing
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): PokemonDetails

    // for getting pokemons with pagination
    @GET("pokemon")
    suspend fun getPokemonListing(): PokemonListing
    @GET("pokemon")
    suspend fun getPokemonListingWithPagination(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): PokemonListing
}
