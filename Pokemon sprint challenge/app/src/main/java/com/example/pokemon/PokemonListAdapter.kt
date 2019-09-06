package com.example.pokemon

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_listing.view.*

class PokemonListAdapter(val data: List<Pokemon>) : RecyclerView.Adapter<PokemonListAdapter.ViewHolder>() {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val t = view.pokemon_element as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_listing, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.t.text = data[position].name

        holder.view.setOnClickListener {
            Log.i("SENDING", "POKEMANS")
            val intent = Intent()
            intent.putExtra("POKEMON", data[position])
            it.context.startActivity(intent)
        }
    }
}