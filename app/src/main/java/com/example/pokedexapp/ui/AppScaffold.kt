package com.example.pokedexapp.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
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

    Scaffold (
    modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
    topBar = { PokedexAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface (
            modifier = Modifier
                .fillMaxSize()
                .padding()
        ) {

            // add viewmodel
            val pokedexViewModel : PokedexViewModel = viewModel(
                factory = PokedexViewModel.Factory
            )

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
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.app_name),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
        },
        scrollBehavior = scrollBehavior,
        modifier = modifier
            .fillMaxWidth()
    )
}