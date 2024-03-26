package com.example.pokedexapp

import android.app.Application
import com.example.pokedexapp.data.ApplicationContainer
import com.example.pokedexapp.data.DefaultApplicationContainer

class PokemonApplicationContainer : Application() {
    lateinit var container: ApplicationContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultApplicationContainer()
    }
}