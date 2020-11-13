package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Restaurant
import com.example.digitalhousefoods.domain.User
import com.example.digitalhousefoods.ui.adapters.RestaurantsAdapter
import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    private val TAG: String = "RestaurantsActivity"
    private val restaurantsList = getAllRestaurants()
    private val restaurantsAdapter = RestaurantsAdapter(restaurantsList, ::callRestaurantDetails)

    lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurants)

        this.user = (intent.getSerializableExtra("user") as? User)!!
        Log.i(TAG, "User recieved $user")

        rcRestaurantsList.adapter = restaurantsAdapter
        rcRestaurantsList.layoutManager = LinearLayoutManager(this)
        rcRestaurantsList.setHasFixedSize(false)
    }

    private fun callRestaurantDetails(restaurant: Restaurant) {
        val intent = Intent(this, RestaurantDetailsActivity::class.java)
        intent.putExtra("restaurant", restaurant)
        startActivity(intent)
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