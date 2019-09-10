package com.example.pokemon

import java.io.Serializable

data class Pokemon (val name: String, val spriteUrl: String, val Id: String, val abilities: List<String>, val types: List<String>) : Serializable
