package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.user_email_password.*

class RegisterActivity : AppCompatActivity() {

    private val TAG: String = "RegisterActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val partialUser = (intent.getSerializableExtra("user") as? User)!!
        Log.i(TAG, "Partial User recieved $partialUser")

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
            Toast.makeText(this, resources.getString(R.string.password_warning), Toast.LENGTH_LONG).show()
            return null
        }

        if (password != confirmedPassword) {
            Toast.makeText(this, resources.getString(R.string.passwords_dont_match), Toast.LENGTH_LONG).show()
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