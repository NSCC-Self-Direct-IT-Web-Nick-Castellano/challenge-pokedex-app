package com.example.pokedexapp.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
//    amphibianUiState: AmphibianUiState,
    modififer : Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
//    retryAction: () -> Unit
) {
    Text(text = "Hello Pokedex!")
}