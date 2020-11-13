package com.example.digitalhousefoods.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.digitalhousefoods.R
import com.example.digitalhousefoods.domain.Plate
import kotlinx.android.synthetic.main.activity_plate_detail.*
import kotlinx.android.synthetic.main.header_details.*

class PlateDetailActivity : AppCompatActivity() {

    private val TAG: String = "PlateDetailActivity"

    lateinit var plate: Plate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        this.plate = (intent.getSerializableExtra("plate") as? Plate)!!
        Log.i(TAG, "Plate recieved $plate")

        ivImgDetails.setImageResource(plate.imageId)
        tvDetailsTitle.text = plate.name
        tvPlateDescription.text = plate.description

        btnDetailsBack.setOnClickListener { finish() }
    }
}