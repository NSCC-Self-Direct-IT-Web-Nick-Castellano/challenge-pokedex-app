package com.example.pokedexapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedexapp.R
import com.example.pokedexapp.ui.screens.HomeScreen
import com.example.pokedexapp.ui.screens.PokedexViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun AppScaffold() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    // add viewmodel
    val pokedexViewModel : PokedexViewModel = viewModel(
        factory = PokedexViewModel.Factory
    )

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { PokedexAppBar(
            scrollBehavior = scrollBehavior,
            onGoBackInHistory = { pokedexViewModel.goBackToUiHistory() }
        ) }
    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {



            HomeScreen(
                pokedexViewModel = pokedexViewModel,
                contentPadding = it
            )
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun PokedexAppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    onGoBackInHistory: () -> Unit,
    modifier: Modifier = Modifier,
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 24.sp,
            )
        },
        navigationIcon = {
             IconButton(onClick = onGoBackInHistory) {
                 Icon(
                     imageVector = Icons.Filled.ArrowBack,
                     contentDescription = "Localized description",
                     tint = Color.White
                 )

             }
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
            .fillMaxWidth()
    )
}