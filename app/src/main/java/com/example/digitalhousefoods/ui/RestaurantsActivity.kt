package com.example.digitalhousefoods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Restaurant
import com.example.digitalhousefoods.domain.User
import com.example.digitalhousefoods.ui.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    private val TAG: String = "RestaurantsActivity"
    private val restaurantsList = getAllRestaurants()
    private val adapter = RestaurantsAdapter(restaurantsList, ::callRestaurantDetails)

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

        rcRestaurantsList.adapter = adapter
        rcRestaurantsList.layoutManager = LinearLayoutManager(this)
        rcRestaurantsList.setHasFixedSize(false)
    }

    private fun callRestaurantDetails(restaurant: Restaurant) {
        Toast.makeText(this, "Restaurant ${restaurant.name} clicked!", Toast.LENGTH_LONG).show()
    }

    // Em um aplicativo de verdade estaria em um service e pegaria de alguma API
    private fun getAllRestaurants(): MutableList<Restaurant> {
        return mutableListOf(
            Restaurant(1, "Tony Roma's", R.drawable.image1, "Av. Lavandisca, 717 - Indianópolis, São Paulo", "22:00"),
            Restaurant(2, "Aoyama - Moema", R.drawable.image4, "Alameda dos Arapanés, 532 - Moema", "00:00"),
            Restaurant(3, "Outback - Moema", R.drawable.image5, "Av. Moaci, 187, 187 - Moema, São Paulo", "00:00"),
            Restaurant(4, "Sí Señor!", R.drawable.image3, "Alameda Jauaperi, 626 - Moema", "01:00"),
        )
    }
}