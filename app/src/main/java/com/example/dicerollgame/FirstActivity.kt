package com.example.dicerollgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_first)

        val textViewTitle = findViewById<TextView>(R.id.textViewTitle)
        val imageDadi = findViewById<ImageView>(R.id.imageDadi)
        val btnAvvia = findViewById<Button>(R.id.btnAvvia)
        btnAvvia.setOnClickListener {
            intent()
        }
    }
    private fun intent(){
        val mioIntent = Intent(this, MainActivity::class.java)
        startActivity(mioIntent)
    }
}