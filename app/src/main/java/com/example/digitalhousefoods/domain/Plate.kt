package com.example.digitalhousefoods.domain

import java.io.Serializable

class Plate (val id: Int, val name: String, val imageId: Int, val restaurantId: Int) : Serializable {

    override fun toString(): String {
        return "Plate(id=$id, name='$name', imageId=$imageId, restaurantId=$restaurantId)"
    }
}