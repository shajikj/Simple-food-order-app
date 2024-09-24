package com.shaji.finfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shaji.recycle.CustomAdapter
import com.shaji.recycle.ItemsViewModel

class OrderActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {

    private lateinit var data: ArrayList<ItemsViewModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // Create a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // Initialize the ArrayList with items and their prices
        data = ArrayList()
        data.add(ItemsViewModel(R.drawable.burger_icon, "Burger", 5.99))
        data.add(ItemsViewModel(R.drawable.pasta_icon, "Pasta", 7.49))
        data.add(ItemsViewModel(R.drawable.pizza_icon, "Pizza", 8.99))
        data.add(ItemsViewModel(R.drawable.sushi_icon, "Sushi", 12.50))
        data.add(ItemsViewModel(R.drawable.tacos_icon, "Tacos", 3.99))

        // Pass the data and the listener (this) to the adapter
        val adapter = CustomAdapter(data, this)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }

    // Implementing the onItemClick method from the interface
    override fun onItemClick(position: Int) {
        // Get the clicked item
        val selectedItem = data[position]

        // Start Order Details Activity and pass the selected item and price
        val intent = Intent(this, OrderDetailsActivity::class.java)
        intent.putExtra("itemName", selectedItem.text)  // Pass the item name
        intent.putExtra("itemImage", selectedItem.image) // Pass the item image
        intent.putExtra("itemPrice", selectedItem.price) // Pass the item price
        startActivity(intent)
    }
}
