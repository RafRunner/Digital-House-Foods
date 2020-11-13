package com.example.digitalhousefoods.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Plate
import com.example.digitalhousefoods.domain.Restaurant
import com.example.digitalhousefoods.ui.adapters.PlatesAdapter
import kotlinx.android.synthetic.main.activity_restaurant_details.*
import kotlinx.android.synthetic.main.header_details.*

class RestaurantDetailsActivity : AppCompatActivity() {

    private val TAG: String = "RestaurantDetailsActivity"
    private val platesList = getAllPlates()

    lateinit var restaurant: Restaurant
    lateinit var platesAdapter: PlatesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant_details)

        this.restaurant = (intent.getSerializableExtra("restaurant") as? Restaurant)!!
        Log.i(TAG, "Restaurant recieved $restaurant")

        this.platesAdapter = PlatesAdapter(getRestaurantPlates(restaurant), ::callPlateDetails)

        ivImgDetails.setImageResource(restaurant.imageId)
        tvDetailsTitle.text = restaurant.name

        rcPlatesList.adapter = platesAdapter
        rcPlatesList.layoutManager = GridLayoutManager(this, 2)
        rcPlatesList.setHasFixedSize(false)

        btnDetailsBack.setOnClickListener { finish() }
    }

    private fun callPlateDetails(plate: Plate) {
        val intent = Intent(this, PlateDetailActivity::class.java)
        intent.putExtra("plate", plate)
        startActivity(intent)
    }


    // Em um aplicativo de verdade estaria em um service e pegaria de alguma API
    private fun getAllPlates(): MutableList<Plate> {
        return mutableListOf(
            Plate(1, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(2, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(3, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(4, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(5, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(6, "Salada com molho Gengibre", R.drawable.image4, 1),
            Plate(7, "Salada com molho Gengibre", R.drawable.image4, 1),

            Plate(8, "Café da manhã continental", R.drawable.image3, 2),
            Plate(9, "Café da manhã continental", R.drawable.image3, 2),
            Plate(10, "Café da manhã continental", R.drawable.image3, 2),
            Plate(11, "Café da manhã continental", R.drawable.image3, 2),
            Plate(12, "Café da manhã continental", R.drawable.image3, 2),
            Plate(13, "Café da manhã continental", R.drawable.image3, 2),
            Plate(14, "Café da manhã continental", R.drawable.image3, 2),

            Plate(15, "Camarão", R.drawable.image1, 3),
            Plate(16, "Camarão", R.drawable.image1, 3),
            Plate(17, "Camarão", R.drawable.image1, 3),
            Plate(18, "Camarão", R.drawable.image1, 3),
            Plate(19, "Camarão", R.drawable.image1, 3),
            Plate(20, "Camarão", R.drawable.image1, 3),
            Plate(21, "Camarão", R.drawable.image1, 3),

            Plate(22, "torrada com ovos", R.drawable.image5, 4),
            Plate(23, "torrada com ovos", R.drawable.image5, 4),
            Plate(24, "torrada com ovos", R.drawable.image5, 4),
            Plate(25, "torrada com ovos", R.drawable.image5, 4),
            Plate(26, "torrada com ovos", R.drawable.image5, 4),
            Plate(27, "torrada com ovos", R.drawable.image5, 4),
            Plate(28, "torrada com ovos", R.drawable.image5, 4),
        )
    }

    private fun getRestaurantPlates(restaurant: Restaurant): MutableList<Plate> =
        platesList.filter { it.restaurantId == restaurant.id }.toMutableList()
}