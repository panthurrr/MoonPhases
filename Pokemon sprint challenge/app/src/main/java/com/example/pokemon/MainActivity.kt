package com.example.pokemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), Callback<Pokemon> {

    val pokemonList = mutableListOf<Pokemon>()
    val pokemonListAdapter = PokemonListAdapter(pokemonList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        list_pokemon_search.apply {
            adapter = pokemonListAdapter
            layoutManager = manager
        }

        img_search.setOnClickListener {
            val search_key = edit_pokemon_search.text.toString()

            if(search_key != "") {
                if(search_key.toIntOrNull() != null){
                    PokemonApiReceiver.getPokemonApiCall().getPokemonById(search_key).enqueue(this)
                } else{
                    PokemonApiReceiver.getPokemonApiCall().getPokemonByName(search_key.toLowerCase()).enqueue(this)
                }
            }
        }
    }

    override fun onFailure(call: Call<Pokemon>, t: Throwable) {
        Toast.makeText(this, "NO RESPONSE FOR API", Toast.LENGTH_SHORT).show()
    }

    override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
        response.body()?.let{
            pokemonList.add(it)
            pokemonListAdapter.notifyDataSetChanged()
        }
    }
}
