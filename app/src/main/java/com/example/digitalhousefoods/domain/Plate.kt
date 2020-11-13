package com.example.digitalhousefoods.domain

class Plate (val name: String, val imageId: Int) {
    override fun toString(): String {
        return "Plate(name='$name', imageId=$imageId)"
    }
}