package com.example.pokedexapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexapp.model.PokemonListing
import com.example.pokedexapp.model.PokemonListingItem
import com.example.pokedexapp.ui.theme.PokedexAppTheme

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    pokemonListingData: PokemonListing
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary)
            .padding(8.dp, 8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Pokemon Count: ${pokemonListingData.count}",
            modifier = Modifier.padding(0.dp, 12.dp),
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White
        )

        Column (
            modifier = Modifier
                .background(MaterialTheme.colorScheme.outlineVariant)
                .padding(8.dp, 8.dp)
                .fillMaxWidth()
        ) {


            LazyColumn(
                modifier = Modifier

            ) {
                items(pokemonListingData.results) { item ->
                    Row {
                        ClickableText(
                            text = AnnotatedString(item.name),
                            modifier = Modifier.padding(8.dp, 12.dp),
                            onClick = {}
                        )
                    }
                }
            }
        }

        Row (
            horizontalArrangement = Arrangement.End,
            modifier = modifier.fillMaxWidth()
        ) {
            val buttonModifier = Modifier
                .clip(CircleShape)
                .padding(8.dp, 0.dp)
            val buttonElevation = null
            val buttonColors = ButtonDefaults.buttonColors(MaterialTheme.colorScheme.surface)
            Button(
                onClick = { /*TODO*/ },
                modifier = buttonModifier,
                elevation = buttonElevation,
                colors = buttonColors
            ) {
                Text(text = "Previous")
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = buttonModifier,
                elevation = buttonElevation,
                colors = buttonColors
            ) {
                Text(text = "Next")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PokemonListScreenPreview(){
    PokedexAppTheme{
        val listOfPokemonItems: List<PokemonListingItem> = listOf<PokemonListingItem>(
            PokemonListingItem(
                name = "pokemon1",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            ),
            PokemonListingItem(
                name = "pokemon2",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            ),
            PokemonListingItem(
                name = "pokemon2",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            ),
        )
        val pokemonListing: PokemonListing = PokemonListing(
            count = 1302,
            next = "https://pokeapi.co/api/v2/pokemon?offset=20&limit=20",
            previous = null,
            results = listOfPokemonItems
        )

        PokemonListScreen(pokemonListingData = pokemonListing)
    }
}