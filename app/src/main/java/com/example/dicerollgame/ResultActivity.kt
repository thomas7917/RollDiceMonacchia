package com.example.dicerollgame

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var diceImageView: ImageView
    private lateinit var resultTextView: TextView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        diceImageView = findViewById(R.id.diceImageView)
        resultTextView = findViewById(R.id.resultTextView)
        backButton = findViewById(R.id.backButton)

        // Recupera il guess dell'utente passato tramite l'intent
        val userGuess = intent.getIntExtra("user_guess", 0)

        // Esegui il lancio del dado: genera un numero casuale da 1 a 6
        val diceResult = (1..6).random()

        // Seleziona l'immagine corrispondente al risultato
        val drawableResource = when (diceResult) {
            1 -> R.drawable.dice_face_1
            2 -> R.drawable.dice_face_2
            3 -> R.drawable.dice_face_3
            4 -> R.drawable.dice_face_4
            5 -> R.drawable.dice_face_5
            else -> R.drawable.dice_face_6
        }
        diceImageView.setImageResource(drawableResource)

        // Confronta il risultato ottenuto con il numero inserito dall'utente
        if (diceResult == userGuess) {
            resultTextView.text = "Hai vinto! Il dado ha fatto: $diceResult"
        } else {
            resultTextView.text = "Hai perso! Il dado ha fatto: $diceResult"
        }

        // Imposta il pulsante per tornare alla schermata iniziale
        backButton.setOnClickListener {
            // Terminando la ResultActivity si torna automaticamente alla MainActivity
            finish()
        }
    }
}
