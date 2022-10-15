package com.example.hammersystems.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammersystems.R
import com.example.hammersystems.domain.model.Pizza
import kotlinx.android.synthetic.main.pizza_row.view.*

class PizzaAdapter : RecyclerView
.Adapter<PizzaAdapter.MyViewHolder>() {

    private val differCallback = object : DiffUtil.ItemCallback<Pizza>(){
        override fun areItemsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Pizza, newItem: Pizza): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.pizza_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val pizza = differ.currentList[position]
        holder.itemView.apply {
            pizzaNameTV.text = pizza.title
            pizzaDetailsTV.text = "pizza from ${pizza.restaurantChain}"
            pizzaPriceTV.text = "от ${(15..45).random() * 10} р"

            Glide.with(this).load(pizza.image).into(pizzaIV)
        }

    }

    override fun getItemCount() = differ.currentList.size
}