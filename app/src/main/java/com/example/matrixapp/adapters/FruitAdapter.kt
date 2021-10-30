package com.example.matrixapp.adapters

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.matrixapp.MainActivity
import com.example.matrixapp.R
import com.example.matrixapp.model.Fruit
import de.hdodenhof.circleimageview.CircleImageView

class FruitAdapter(
    private var mDataSet: List<Fruit>,
    private val clickHandler: (Fruit) -> Unit
) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val fruitName : TextView = itemView.findViewById(R.id.fruit_name)
        private val fruitImage : CircleImageView = itemView.findViewById(R.id.fruit_image)
        fun bind(fruit: Fruit){
            fruitName.text = fruit.name
            Glide
                .with(itemView)
                .load(fruit.imageUrl)
                .centerCrop()
                .placeholder(R.drawable.loading_image_24)
                .into(fruitImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mDataSet[position])
        holder.itemView.setOnClickListener {
            clickHandler(mDataSet[position])
        }
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }
}