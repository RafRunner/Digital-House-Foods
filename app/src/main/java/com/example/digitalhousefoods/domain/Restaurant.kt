package com.example.digitalhousefoods.domain

class Restaurant(
    val id: Int,
    val name: String,
    val imageId: Int,
    val address: String,
    val closingTime: String
) {
    val plates: MutableList<Plate> = mutableListOf()

    override fun toString(): String {
        return "Restaurant(id=$id, name='$name', imageId=$imageId, address='$address', closingTime='$closingTime')"
    }
}