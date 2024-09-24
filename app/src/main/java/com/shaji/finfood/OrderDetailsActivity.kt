package com.shaji.finfood

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_details)

        // Retrieve data from intent
        val itemName = intent.getStringExtra("itemName")
        val itemImage = intent.getIntExtra("itemImage", 0)
        val itemPrice = intent.getDoubleExtra("itemPrice", 0.0)

        // Find views
        val textView: TextView = findViewById(R.id.itemName)
        val imageView: ImageView = findViewById(R.id.itemImage)
        val priceView: TextView = findViewById(R.id.itemPrice)
        val orderButton: Button = findViewById(R.id.orderButton)

        // Set data to views
        textView.text = itemName
        imageView.setImageResource(itemImage)
        priceView.text = String.format("$%.2f", itemPrice)

        // Set click listener for the "Order" button
        orderButton.setOnClickListener {
            // Start OrderConfirmedActivity
            val intent = Intent(this, OrderConfirmedActivity::class.java)
            startActivity(intent)
        }
    }
}
