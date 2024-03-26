package com.example.pokedexapp.ui.screens

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedexapp.R
import com.example.pokedexapp.model.PokemonDetails

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    pokemonDetails: PokemonDetails
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp, 8.dp),
    ) {
        Text(text = "Pokemon Name")
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/132.png")
                .crossfade(true)
                .build()
            ,
            contentDescription = "pokemon image description",
            contentScale = ContentScale.Crop,
            error = painterResource(id = R.drawable.ic_broken_image),
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = "pokemon description"
        )
    }
}

@Preview
@Composable
fun PokemonDetailScreenPreview(){

}