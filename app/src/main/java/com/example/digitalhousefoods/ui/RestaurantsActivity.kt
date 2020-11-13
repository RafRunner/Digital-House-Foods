package com.example.digitalhousefoods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User

class RestaurantsActivity : AppCompatActivity() {

    private val TAG: String = "RestaurantsActivity"

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        val user = intent.getSerializableExtra("user") as? User

        // Nunca deve acontecer, se acontecer é falha do programador
        if (user == null) {
            Log.e(TAG, "User was not recieved on onCreate")
            finish()
            return
        }

        this.user = user
    }

}