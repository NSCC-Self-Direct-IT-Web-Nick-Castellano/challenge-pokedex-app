package com.example.pokedexapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.PokemonApplicationContainer
import com.example.pokedexapp.data.PokemonRepository
import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.model.PokemonListing

sealed interface PokemonUiState {
    data class PokemonListingSuccess(val pokemonListing: PokemonListing) : PokemonUiState
    data class pokemonDetailsSuccess(val pokemonDetails: PokemonDetails) : PokemonUiState


    // the loading and error ui states
    object Error : PokemonUiState
    object Loading : PokemonUiState
}

class PokedexViewModel (
    private val pokemonRepository : PokemonRepository
) : ViewModel() {

    // initiate the ui state
    var pokemonUiState : PokemonUiState by mutableStateOf(PokemonUiState.Loading)
        private set


    // make factory companion object
    companion object {
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PokemonApplicationContainer)
                val pokemonRepository = application.container.pokemonRepository

                PokedexViewModel(pokemonRepository = pokemonRepository)
            }
        }
    }
}