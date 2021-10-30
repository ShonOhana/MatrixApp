package com.example.matrixapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.matrixapp.constants.FRUIT_DESCRIPTION_EXTRA
import com.example.matrixapp.constants.FRUIT_IMAGE_EXTRA
import com.example.matrixapp.constants.FRUIT_NAME_EXTRA
import com.example.matrixapp.constants.FRUIT_PRICE_EXTRA

class DetailsActivity : AppCompatActivity() {

    private lateinit var fruitName: TextView
    private lateinit var fruitDescription: TextView
    private lateinit var fruitImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        title = getString(R.string.details_activity_title)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)


        fruitImage = findViewById(R.id.big_image)
        fruitName = findViewById(R.id.fruit_name)
        fruitDescription = findViewById(R.id.fruit_description)

        val name: String = intent.getStringExtra(FRUIT_NAME_EXTRA) ?: ""
        val imageUrl: String = intent.getStringExtra(FRUIT_IMAGE_EXTRA) ?: ""
        val description: String = intent.getStringExtra(FRUIT_DESCRIPTION_EXTRA) ?: ""
        val price: Double = intent.getDoubleExtra(FRUIT_PRICE_EXTRA,0.0)

        fruitName.text = name
        fruitDescription.text = "${description}  \n ${price}"

        Glide
            .with(this)
            .load(imageUrl)
            .centerCrop()
            .placeholder(R.drawable.loading_image_24)
            .into(fruitImage)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}