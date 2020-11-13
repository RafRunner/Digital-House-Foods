package com.example.digitalhousefoods.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Plate

class PlatesAdapter(private val platesList: MutableList<Plate>, private val onPlateClicked: (p: Plate) -> Unit)
    : RecyclerView.Adapter<PlatesAdapter.PlateViewHolder>() {

    class PlateViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var plateId: Int = 0
        val ivImgPlate: ImageView = view.findViewById(R.id.ivImgPlate)
        val tvPlateName: TextView = view.findViewById(R.id.tvPlateName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlateViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_plate, parent, false)
        return PlateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PlateViewHolder, position: Int) {
        val plate = platesList[position]

        holder.plateId = plate.id
        holder.ivImgPlate.setImageResource(plate.imageId)
        holder.tvPlateName.text = plate.name

        holder.view.setOnClickListener {
            onPlateClicked(plate)
        }
    }

    override fun getItemCount(): Int =platesList.size
}