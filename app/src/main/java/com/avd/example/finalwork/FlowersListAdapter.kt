package com.avd.example.finalwork

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FlowersListAdapter(private val flowersNames: List<String>) :
    RecyclerView.Adapter<FlowersViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlowersViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.flowers_item, parent, false)
        return FlowersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FlowersViewHolder, position: Int) {
        val name = flowersNames[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return flowersNames.size
    }

}