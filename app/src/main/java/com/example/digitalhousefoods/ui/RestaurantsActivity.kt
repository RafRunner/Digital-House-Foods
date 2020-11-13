package com.example.digitalhousefoods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.User

class RestaurantsActivity : AppCompatActivity() {

    val TAG: String = RestaurantsActivity::class.simpleName ?: ""

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        val user = intent.getSerializableExtra("user") as? User

        // Nunca deve acontecer
        if (user == null) {
            Log.e(TAG, "User was not recieved on onCreate")
            finish()
            return
        }

        this.user = user
    }

}