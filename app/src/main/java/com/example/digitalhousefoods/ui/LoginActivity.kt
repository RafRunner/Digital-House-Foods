package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.user_email_password.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

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