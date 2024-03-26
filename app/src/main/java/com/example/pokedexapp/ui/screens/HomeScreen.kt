package com.example.pokedexapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.pokedexapp.R

@Composable
fun HomeScreen(
    pokemonUiState: PokemonUiState,
    modififer : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
//    retryAction: () -> Unit
) {
//    Text(text = "Hello Pokedex!"
    when (pokemonUiState) {
        is PokemonUiState.Loading -> LoadingScreen(
            modififer = modififer.fillMaxSize()
        )
        is PokemonUiState.Error -> ErrorScreen(
            retryAction = {  },
            modififer = modififer.fillMaxSize()
        )

        is PokemonUiState.PokemonListingSuccess -> {
            PokemonListScreen(
                pokemonListingData = pokemonUiState.pokemonListing
            )
        }

        is PokemonUiState.pokemonDetailsSuccess -> {
            Text(text = "Pokemons Details Retrieved Successfully")
        }
    }
}

@Composable
fun LoadingScreen(modififer: Modifier = Modifier) {
    Text(text = stringResource(id = R.string.loading))
}

@Composable
fun ErrorScreen(
    modififer: Modifier = Modifier,
    retryAction: () -> Unit
) {
    Column (
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modififer
    ) {
        Text(text = stringResource(id = R.string.fetch_error))
        Button(onClick = retryAction) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}