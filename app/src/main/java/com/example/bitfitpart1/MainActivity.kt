package com.example.bitfitpart1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitpart1.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import java.security.AccessController.getContext


class MainActivity : AppCompatActivity() {
    private val items = mutableListOf<FoodEntity>()
    private lateinit var itemsRv: RecyclerView
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        ///recyclerView
        itemsRv=findViewById<RecyclerView>(R.id.itemRv)
        var addBtn=findViewById<Button>(R.id.addButton)

        // Create adapter passing in the list of food items
        val adapter = FoodAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter

        lifecycleScope.launch {
            (application as BitFitApplication).db.FoodDao().getAll().collect { databaseList ->
                databaseList.map { mappedList ->

                    items.addAll(listOf(mappedList))
                    adapter.notifyDataSetChanged()
                }
            }
        }


        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this).also {
            val dividerItemDecoration = DividerItemDecoration(this, it.orientation)
            itemsRv.addItemDecoration(dividerItemDecoration)
        }

        addBtn.setOnClickListener {

            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)

        }


    }
}