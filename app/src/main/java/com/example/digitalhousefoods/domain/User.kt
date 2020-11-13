package com.example.digitalhousefoods.domain

import java.io.Serializable

class User (val name: String, val email: String, val password: String): Serializable {
    override fun toString(): String {
        return "User(name='$name', email='$email', password='$password')"
    }
}