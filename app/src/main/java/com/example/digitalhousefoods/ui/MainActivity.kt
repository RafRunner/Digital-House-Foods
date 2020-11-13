package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.user_email_password.*

// Essa é a activity responssável pelo login (LoginActivity)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            // Em uma aplicação de verdaderia teríamos que confirmar o login do usuário antes
            callRestaurants(getPartialUser())
        }

        btnRegister.setOnClickListener {
            callRegister(getPartialUser())
        }
    }

    private fun getPartialUser(): User {
        val email = tiEmail.text.toString()
        val password = tiPassword.text.toString()

        return User("", email, password)
    }

    private fun callActivityWithPartialUser(partialUser: User, cls: Class<*>) {
        val intent = Intent(this, cls)
        intent.putExtra("user", partialUser)
        startActivity(intent)
    }

    private fun callRegister(partialUser: User) = callActivityWithPartialUser(partialUser, RegisterActivity::class.java)

    private fun callRestaurants(partialUser: User)  = callActivityWithPartialUser(partialUser, RestaurantsActivity::class.java)
}