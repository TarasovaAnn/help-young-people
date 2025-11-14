package com.example.indproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
            var button1: Button = findViewById(R.id.btn1)
            button1.setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
        }
        var button2: Button = findViewById(R.id.btn2)
        button2.setOnClickListener {
            val intent = Intent(this, CleaningActivity::class.java)
            startActivity(intent)
        }
        var button4: Button = findViewById(R.id.btn4)
        button4.setOnClickListener {
            val intent = Intent(this, TechnActivity::class.java)
            startActivity(intent)
        }
    }
}