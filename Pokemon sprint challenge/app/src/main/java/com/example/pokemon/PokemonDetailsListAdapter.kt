package com.example.pokemon

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.pokemon_details_view.view.*

class PokemonDetailsListAdapter(val data: Pokemon): RecyclerView.Adapter<PokemonDetailsListAdapter.ViewHolder>(){

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val typesView = view.pokemon_types
        val abilitiesView = view.pokemon_abilities
        val nameView = view.pokemon_name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_details_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        data.types.forEach {
            holder.typesView.text = "${holder.typesView.text} \n \t \n"
        }
        data.abilities.forEach {
            holder.abilitiesView.text = "${holder.abilitiesView.text} \n \t \n"
        }
        holder.nameView.text = data.name
    }
}