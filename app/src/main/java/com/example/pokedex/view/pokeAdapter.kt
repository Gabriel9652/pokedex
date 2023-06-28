package com.example.pokedex.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.R
import com.example.pokedex.domain.Pokemon


class pokeAdapter(val items: List<Pokemon>) : RecyclerView.Adapter<pokeAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item, parent , false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.bindView(item)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(item: Pokemon) = with(itemView){
            val ivpokemon = findViewById<ImageView>(R.id.ivPokemon)
            val txt_num_pokemon = findViewById<TextView>(R.id.txt_num_pokemon)
            val txt_name = findViewById<TextView>(R.id.txt_name)
            val txt_tip1 = findViewById<TextView>(R.id.txt_tip1)
            val txt_tip2 = findViewById<TextView>(R.id.txt_tip2)

            //TODO: Load image with Glide

            txt_num_pokemon.text = "Nº ${item.formattedNumber}"
            txt_name.text = item.name
            txt_tip1.text = item.types[0].name

            if(item.types.size>1){
                txt_tip2.visibility = View.VISIBLE
                txt_tip2.text = item.types[1].name
            }else{
                txt_tip2.visibility = View.GONE
            }

        }

    }
}
