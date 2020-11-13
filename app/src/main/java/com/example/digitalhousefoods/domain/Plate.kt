package com.example.digitalhousefoods.domain

class Plate (val id: Int, val name: String, val imageId: Int, val restaurantId: Int) {

    override fun toString(): String {
        return "Plate(id=$id, name='$name', imageId=$imageId, restaurantId=$restaurantId)"
    }
}