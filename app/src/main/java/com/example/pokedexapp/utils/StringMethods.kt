package com.example.pokedexapp.utils

interface StringMethods {

    companion object {
        fun capitalizeString(oldString: String): String {
            return oldString.replaceFirstChar { c: Char ->
                c.uppercase()
            }
        }
    }
}