package com.example.pokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonAPI {

    @GET("/pokemon/{pokename}") //gets the pokemon name that we want from the pokemon api
    fun getPokemonByName(@Path("pokename") pokename : String) : Call<Pokemon>

    @GET("/pokemon/{id}")
    fun getPokemonById(@Path("id") id: String) : Call<Pokemon>

}