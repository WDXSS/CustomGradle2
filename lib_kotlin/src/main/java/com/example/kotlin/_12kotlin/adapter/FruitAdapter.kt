package com.example.kotlin._12kotlin.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin.R
import com.example.kotlin._12kotlin.adapter.FruitAdapter.ViewHolder
import com.example.kotlin._12kotlin.enity.Fruit

@Suppress("UNREACHABLE_CODE")
class FruitAdapter(val context: Context, val fruitList: List<Fruit>) : RecyclerView.Adapter<ViewHolder>() {


    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val fruit = fruitList.get(position)
        holder.fruitName.text = fruit.name
        Glide.with(context).load(fruit.imageId).into(holder.fruitImg)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.kotlin_12_material_cardview_fruit_item, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitName: TextView = view.findViewById(R.id.fruitName)
        val fruitImg: ImageView = view.findViewById(R.id.fruitImage)

    }

}