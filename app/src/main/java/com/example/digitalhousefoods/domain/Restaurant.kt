package com.example.digitalhousefoods.domain

class Restaurant(
    val name: String,
    val imageId: Int,
    val address: String,
    val closingTime: String,
    var plates: List<Plate>
) {
    override fun toString(): String {
        return "Restaurant(name='$name', imageId=$imageId, address='$address', closingTime=$closingTime)"
    }
}