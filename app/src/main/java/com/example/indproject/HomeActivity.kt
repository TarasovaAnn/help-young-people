package com.example.indproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var button: Button = findViewById(R.id.back_btn)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val clickableSpan = findViewById<TextView>(R.id.text)
        clickableSpan.setOnClickListener {
            val intent= Intent(this, CookActivity::class.java)
            startActivity(intent)
        }
        val clickableSpan2 = findViewById<TextView>(R.id.text2)
        clickableSpan2.setOnClickListener {
            val intent= Intent(this, DefrostActivity::class.java)
            startActivity(intent)
        }
        val clickableSpan3 = findViewById<TextView>(R.id.text23)
        clickableSpan3.setOnClickListener {
            val intent= Intent(this, FoodSpoilageActivity::class.java)
            startActivity(intent)
        }
    }
}