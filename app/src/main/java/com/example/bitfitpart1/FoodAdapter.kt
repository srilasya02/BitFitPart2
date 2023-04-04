package com.example.bitfitpart1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class FoodAdapter (private val items : List<FoodEntity>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        val nameTextView: TextView
        val calCountTextView: TextView

        init {
            nameTextView=itemView.findViewById(R.id.FoodName)
            calCountTextView=itemView.findViewById(R.id.calorieCount)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.activity_detail, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item=items.get(position)

        holder.nameTextView.text = item.food
        holder.calCountTextView.text = item.calCount


    }

    override fun getItemCount(): Int {
        return items.size
    }



}


