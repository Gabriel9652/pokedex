package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex.api.pokemonRepository
import com.example.pokedex.domain.Pokemon
import com.example.pokedex.domain.pokemonsType
import com.example.pokedex.view.pokeAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvpokemon)

        val layoutManager = LinearLayoutManager(this)

        val bulbasaur = Pokemon(
            "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png",
            1,
            "Bulbasaur",
            listOf(pokemonsType("Grass"))
        )

        val pokemosApi = pokemonRepository.listPokemons()

        val pokemons = listOf(
            bulbasaur,bulbasaur,bulbasaur,bulbasaur
        )
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = pokeAdapter(pokemons)
    }
}