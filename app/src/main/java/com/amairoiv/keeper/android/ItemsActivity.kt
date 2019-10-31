package com.amairoiv.keeper.android

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.amairoiv.keeper.android.adapter.ItemAdapter
import com.amairoiv.keeper.android.model.Item
import com.amairoiv.keeper.android.model.Place

class ItemsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)
        showItemsView()
    }

    private fun showItemsView() {
        val items = intent.extras?.get("ITEMS") as Array<Item>

        findViewById<TextView>(R.id.noItemsText).visibility = if (items.isEmpty()) View.VISIBLE else View.GONE

        val listView = findViewById<ListView>(R.id.items)

        val itemsList = ArrayList(items.toList())

        val adapter = ItemAdapter(this, itemsList)
        listView.adapter = adapter


        listView.setOnItemClickListener { _, _, position, _ ->
            val item = itemsList[position]

            val intent = Intent(this, ItemInfoActivity::class.java)
            intent.putExtra("ITEM", item)

            var location = this.intent.extras?.getSerializable("LOCATION") as Array<String>?
            intent.putExtra("LOCATION", location)

            startActivity(intent)
        }
    }
}
