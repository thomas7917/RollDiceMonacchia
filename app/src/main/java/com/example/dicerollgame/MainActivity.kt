package com.example.dicerollgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var guessEditText: EditText
    private lateinit var playButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        guessEditText = findViewById(R.id.guessEditText)
        playButton = findViewById(R.id.playButton)

        playButton.setOnClickListener {
            val input = guessEditText.text.toString()
            val userGuess = input.toIntOrNull()

            // Validazione dell'input: deve essere un numero compreso tra 1 e 6
            if (userGuess == null || userGuess !in 1..6) {
                Toast.makeText(this, "Inserisci un numero valido da 1 a 6", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Prepara l'intent per passare alla ResultActivity
            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("user_guess", userGuess)
            }
            startActivity(intent)
        }
    }
}
