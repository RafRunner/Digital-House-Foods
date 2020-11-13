package com.example.digitalhousefoods.domain

import java.io.Serializable

class Restaurant(
    val id: Int,
    val name: String,
    val imageId: Int,
    val address: String,
    val closingTime: String
) : Serializable {

    override fun toString(): String {
        return "Restaurant(id=$id, name='$name', imageId=$imageId, address='$address', closingTime='$closingTime')"
    }
}