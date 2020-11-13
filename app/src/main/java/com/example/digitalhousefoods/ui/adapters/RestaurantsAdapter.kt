package com.example.digitalhousefoods.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Restaurant

class RestaurantsAdapter(private val restaurantList: MutableList<Restaurant>, private val onRestaurantClicked: (r: Restaurant) -> Unit) :
    RecyclerView.Adapter<RestaurantsAdapter.RestaurantsViewHolder>() {

    class RestaurantsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var restaurantId: Int = 0
        val ivImgRestaurant: ImageView = view.findViewById(R.id.ivImgRestaurant)
        val tvRestaurantName: TextView = view.findViewById(R.id.tvRestaurantName)
        val tvRestaurantAddress: TextView = view.findViewById(R.id.tvRestaurantAddress)
        val tvRestaurantClosingTime: TextView = view.findViewById(R.id.tvRestaurantClosingTime)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RestaurantsViewHolder, position: Int) {
        val restaurant = restaurantList[position]

        holder.restaurantId = restaurant.id
        holder.ivImgRestaurant.setImageResource(restaurant.imageId)
        holder.tvRestaurantName.text = restaurant.name
        holder.tvRestaurantAddress.text = restaurant.address
        holder.tvRestaurantClosingTime.text = holder.view.resources.getString(R.string.tv_closing_time).format(restaurant.closingTime)

        holder.view.setOnClickListener {
            onRestaurantClicked(restaurant)
        }

        if (position == itemCount - 1) {
            val params = holder.itemView.layoutParams as RecyclerView.LayoutParams
            params.bottomMargin = 200
            holder.itemView.layoutParams = params
        }
    }

    override fun getItemCount(): Int = restaurantList.size

}