package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_pokemon_details.*

class PokemonDetailsActivity : AppCompatActivity() {

    lateinit var pokemonDetailsListAdapter : PokemonDetailsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_details)

        intent.getSerializableExtra("POKEMON")?.let{
            //start the background activity to download the sprite url
            pokemonDetailsListAdapter = PokemonDetailsListAdapter(it as Pokemon)
        }
        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        pokemon_details.apply {
            hasFixedSize()
            adapter = pokemonDetailsListAdapter
            layoutManager = manager
        }
    }
}
