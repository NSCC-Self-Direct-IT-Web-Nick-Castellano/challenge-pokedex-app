# Android Compose and Retrofit Pokedex App

This Android application is a Pokedex that allows users to navigate through different Pokémon and view detailed descriptions using Jetpack Compose for UI and Retrofit for API communication. The app supports Android API level 24 (Android 7.0, Nougat) and above.

## Features

- **Pokémon List**: View a list of Pokémon with their names and images.
- **Pokémon Details**: Select a Pokémon to view its detailed information, including type, abilities, and stats.
- **Search**: Search for specific Pokémon by name.
- **Favorites**: Mark Pokémon as favorites for easy access later.

## Technologies Used

- **Jetpack Compose**: For building a modern and reactive UI.
- **Retrofit**: For making API requests to retrieve Pokémon data.
- **MVVM Architecture**: Organize code using Model-View-ViewModel architecture for separation of concerns.
- **Room Database**: Store favorite Pokémon locally for offline access.
- **Navigation Component**: Handle navigation between screens.

## Getting Started

1. Clone the repository.
2. Open the project in Android Studio.
3. Build and run the app on a device or emulator with Android API level 24 (Nougat) or higher.

## API

This app uses the [PokéAPI](https://pokeapi.co/) to fetch Pokémon data. Make sure you have an active internet connection to load Pokémon information.
