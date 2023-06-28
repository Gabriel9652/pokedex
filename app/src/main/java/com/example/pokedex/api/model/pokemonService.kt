package com.example.pokedex.api.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface pokemonService {
    @GET("pokemon")
    fun listPokemons(@Query("limit") limit: Int): Call<pokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(number: Int): Call<PokemonApiResult>
}