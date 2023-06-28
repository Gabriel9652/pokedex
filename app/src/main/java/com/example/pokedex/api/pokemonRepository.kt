package com.example.pokedex.api

import android.util.Log
import com.example.pokedex.api.model.pokemonService
import com.example.pokedex.api.model.pokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object pokemonRepository {
    private val service:pokemonService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(pokemonService::class.java)
    }
    fun listPokemons(limit: Int = 151){
        val Call = service.listPokemons(limit)
        Call.enqueue(object : Callback<pokemonsApiResult> {
            override fun onResponse(
                call: Call<pokemonsApiResult>,
                response: Response<pokemonsApiResult>
            ) {
                Log.d("POKEMON_API","a lista de pokemons foi carrgada")
            }
            override fun onFailure(call: Call<pokemonsApiResult>, t: Throwable) {
                Log.e("POKEMON_API", "Erro ao carregar", t)
            }
        })
    }
}
