package com.avd.example.finalwork

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val flowersNameText: TextView = itemView.findViewById(R.id.favorite_flowers_list)

    fun bind(name: String) {
        flowersNameText.text = name
    }

}