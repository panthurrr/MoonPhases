package com.example.pokemon

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class PokemonApiReceiver {

    companion object {
        const val BASE_URL = "https://pokeapi.co/api/v2"

        fun getPokemonApiCall(): PokemonAPI {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            return retrofit.create(PokemonAPI::class.java)
        }
    }
}