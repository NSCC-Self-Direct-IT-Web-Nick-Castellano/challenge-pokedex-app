package com.example.pokedexapp.ui.screens

import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedexapp.R
import com.example.pokedexapp.model.PokemonDetails
import com.example.pokedexapp.utils.StringMethods
import java.util.Locale

@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    pokemonDetails: PokemonDetails
) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp, 80.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            text = StringMethods.capitalizeString(pokemonDetails.name),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Row (
            modifier = modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {


            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(pokemonDetails.sprites.front_default)
                    .crossfade(true)
                    .build(),
                contentDescription = "pokemon image description",
                contentScale = ContentScale.FillWidth,
                error = painterResource(id = R.drawable.ic_broken_image),
                modifier = Modifier
                    .padding(16.dp)
                    .height(200.dp)
            )
        }

        Text(
            text = "Type: ${StringMethods.capitalizeString(pokemonDetails.types.get(0).type.name)}",
            fontSize = 16.sp,
            color = Color.White,
        )
        Text(
            text = "Weight: ${pokemonDetails.weight}",
            fontSize = 16.sp,
            color = Color.White,
        )
        Text(
            text = "Height: ${pokemonDetails.height}",
            fontSize = 16.sp,
            color = Color.White,
        )


    }
}
