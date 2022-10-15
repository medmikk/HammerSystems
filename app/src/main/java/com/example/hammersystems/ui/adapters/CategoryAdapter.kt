package com.example.hammersystems.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.hammersystems.R
import kotlinx.android.synthetic.main.category_row.view.*

class CategoryAdapter(private val cats: List<String>) : RecyclerView
.Adapter<CategoryAdapter.MyViewHolder>() {

    var cheked : View? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryTV: TextView = itemView.findViewById(R.id.categoryTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.categoryTV.text = cats[position]

        if(cheked == null && position == 0) {
            cheked = holder.itemView
            cheked?.cardviewCategory?.setBackgroundColor(ContextCompat.getColor(holder.itemView.context, R.color.pink_dirty))
            cheked?.categoryTV?.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.pink_dark))
        }

        holder.itemView.setOnClickListener{
            cheked?.cardviewCategory?.setBackgroundColor(ContextCompat.getColor(it.context, R.color.white))
            cheked?.categoryTV?.setTextColor(ContextCompat.getColor(it.context, R.color.grey_light))
            cheked = it
            it.cardviewCategory.setBackgroundColor(ContextCompat.getColor(it.context, R.color.pink_dirty))
            it.categoryTV.setTextColor(ContextCompat.getColor(it.context, R.color.pink_dark))
        }
    }

    fun selectItem(){

    }

    override fun getItemCount() = cats.size
}