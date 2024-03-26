package com.example.pokedexapp.ui.screens

import android.util.Log
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
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
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

    // the ui state history
    private val _uiStateHistory = MutableStateFlow<List<PokemonUiState>>(emptyList())
    val uiStateHistory: StateFlow<List<PokemonUiState>> = _uiStateHistory

    // the first thing we initialize on view model creation is the getPokemonListing
    init {
        getPokemonListing()
    }

    // every time we navigate, add to ui state history
    fun addToUiStateHistory(uiState: PokemonUiState) {
        // print the log count
        val updatedList = _uiStateHistory.value.toMutableList().apply { add(uiState) }
        _uiStateHistory.value = updatedList

    }

    fun goBackToUiHistory() {
        val currentHistory = _uiStateHistory.value.toMutableList()

        if (currentHistory.isNotEmpty()) {
            pokemonUiState = currentHistory.last()

            currentHistory.removeLast() // Remove the last UI state
            _uiStateHistory.value = currentHistory
        }
    }



    fun getPokemonListing() {
        viewModelScope.launch {
            if (pokemonUiState != PokemonUiState.Loading && pokemonUiState != PokemonUiState.Error) {
                addToUiStateHistory(pokemonUiState)
            }

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
            if (pokemonUiState != PokemonUiState.Loading && pokemonUiState != PokemonUiState.Error) {
                addToUiStateHistory(pokemonUiState)
            }

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
