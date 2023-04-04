package com.example.bitfitpart1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private const val TAG = "DetailActivity"
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        var recBtn=findViewById<Button>(R.id.recordButton)

        recBtn.setOnClickListener {

            val food=findViewById<EditText>(R.id.foodEv).text.toString()
            val calories=findViewById<EditText>(R.id.calorieEv).text.toString()

            //coroutine

            lifecycleScope.launch(Dispatchers.IO) {
                (application as BitFitApplication).db.FoodDao().insert(
                    FoodEntity(food, calories)
                )
            }

            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

        }

    }

}