package com.shaji.recycle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shaji.finfood.R

class CustomAdapter(
    private val mList: List<ItemsViewModel>,
    private val listener: OnItemClickListener // Added listener for item click
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // Interface to handle click events
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view) // Return an instance of CustomAdapter.ViewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        // Set the image and text
        holder.imageView.setImageResource(itemsViewModel.image)
        holder.textView.text = itemsViewModel.text

        // Handle item click
        holder.itemView.setOnClickListener {
            listener.onItemClick(position) // Notify listener when item is clicked
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
    }
}
