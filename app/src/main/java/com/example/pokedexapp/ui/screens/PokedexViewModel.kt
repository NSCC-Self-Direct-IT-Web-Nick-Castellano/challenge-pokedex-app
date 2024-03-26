package com.example.pokedexapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.pokedexapp.PokemonApplicationContainer
import com.example.pokedexapp.data.PokemonRepository
import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.model.PokemonListing
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

sealed interface PokemonUiState {
    data class PokemonListingSuccess(val pokemonListing: PokemonListing) : PokemonUiState
    data class PokemonDetailsSuccess(val pokemonDetails: PokemonDetails) : PokemonUiState


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

    // the first thing we initialize on view model creation is the getPokemonListing
    init {
        getPokemonListing()
    }

    fun getPokemonListing() {
        viewModelScope.launch {
            pokemonUiState = PokemonUiState.Loading

            pokemonUiState = try {
                PokemonUiState.PokemonListingSuccess(
                    pokemonRepository.getPokemonListingRepoFun()
                )
            } catch (e : IOException) {
                PokemonUiState.Error
            } catch (e : HttpException) {
                PokemonUiState.Error
            }
        }
    }

    fun getPokemonDetails(name: String) {
        viewModelScope.launch {
            pokemonUiState = PokemonUiState.Loading

            pokemonUiState = try {
                PokemonUiState.PokemonDetailsSuccess(
                    pokemonRepository.getPokemonDetailsRepoFun(name = name)
                )
            } catch (e : IOException) {
                PokemonUiState.Error
            } catch (e : HttpException) {
                PokemonUiState.Error
            }
        }
    }

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