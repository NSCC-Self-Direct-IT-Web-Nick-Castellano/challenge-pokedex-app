package com.example.pokedexapp.data

import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.model.PokemonListing
import com.example.pokedexapp.network.PokemonApiService

/**
 * We will have an interface that our network repository will call
 */
interface PokemonRepository {
    suspend fun getPokemonDetailsRepoFun(name: String) : PokemonDetails
    suspend fun getPokemonListingRepoFun() : PokemonListing
    suspend fun getPokemonListingRepoFunWithPagination(offset: Int, limit: Int) : PokemonListing


}
class NetworkPokemonRepository(
    private val apiService: PokemonApiService
) : PokemonRepository {
    override suspend fun getPokemonDetailsRepoFun(name: String): PokemonDetails = apiService.getPokemonDetails(name)
    override suspend fun getPokemonListingRepoFun(): PokemonListing = apiService.getPokemonListing()
    override suspend fun getPokemonListingRepoFunWithPagination(offset: Int, limit: Int): PokemonListing = apiService.getPokemonListingWithPagination(offset, limit)


}