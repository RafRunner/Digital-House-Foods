package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.user_email_password.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val partialUser = intent.getSerializableExtra("user") as? User

        if (partialUser != null) {
            tiEmail.setText(partialUser.email)
            tiPassword.setText(partialUser.password)
            tiConfirmPassword.setText(partialUser.password)
        }

        btnRegister.setOnClickListener {
            val user = getUser() ?: return@setOnClickListener
            // Em uma aplicação de verdaderia teríamos que confirmar a criação do usuário antes
            callRestaurants(user)
        }
    }

    private fun getUser(): User? {
        val name = tiName.text.toString()
        val email = tiEmail.text.toString()
        val password = tiPassword.text.toString()
        val confirmedPassword = tiConfirmPassword.text.toString()

        if (password.length < 8) {
            Toast.makeText(this, "Password must be at least 8 characters long!", Toast.LENGTH_LONG).show()
            return null
        }

        if (password != confirmedPassword) {
            Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_LONG).show()
            return null
        }

        return User(name, email, password)
    }

    private fun callRestaurants(user: User) {
        val intent = Intent(this, RestaurantsActivity::class.java)
        intent.putExtra("user", user)
        startActivity(intent)
    }
}