package com.example.pokedex.api.model

import com.example.pokedex.domain.pokemonsType

//serializar
data class pokemonsApiResult(
    val count:Int,
    val next:String?,
    val previous:String?,
    val results: List<pokemonResult>
)
data class pokemonResult(
    val name:String,
    val url:String

)
data class PokemonApiResult(
    val id:Int,
    val name: String,
    val pokemontype: PokemonTypeSlot
)
data class PokemonTypeSlot(
    val slot: Int,
    val type: pokemonsType
)