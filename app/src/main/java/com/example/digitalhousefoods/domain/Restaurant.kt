package com.example.digitalhousefoods.domain

import java.time.LocalTime

class Restaurant(
    val name: String,
    val imageId: Int,
    val address: String,
    val closingTime: LocalTime,
    var plates: List<Plate>
) {
    override fun toString(): String {
        return "Restaurant(name='$name', imageId=$imageId, address='$address', closingTime=$closingTime)"
    }
}