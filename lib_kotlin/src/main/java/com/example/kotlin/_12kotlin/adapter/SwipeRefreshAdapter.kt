package com.example.kotlin._12kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin.R
import com.example.kotlin._12kotlin.enity.Fruit


class SwipeRefreshAdapter() : RecyclerView.Adapter<SwipeRefreshAdapter.ViewHolder>() {
    lateinit var context: Context
    lateinit var fruitList: ArrayList<Fruit>

    constructor(context: Context, fruitList: ArrayList<Fruit>):this() {
        this.context = context
        this.fruitList = fruitList

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.kotlin_12_material_cardview_fruit_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}