package com.example.pokedex.domain

data class Pokemon (
    val imageUrl:String,
    val number:Int,
    val name:String,
    val types:List<pokemonsType>

){
    val formattedNumber = number.toString().padStart(3,'0')
}