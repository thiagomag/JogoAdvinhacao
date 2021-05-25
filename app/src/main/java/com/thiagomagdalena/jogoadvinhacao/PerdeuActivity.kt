package com.thiagomagdalena.jogoadvinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import pl.droidsonroids.gif.GifImageView

class PerdeuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)

        val reiniciar = findViewById<Button>(R.id.recomecar)

        reiniciar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val gif = when ((1..6).random()) {
            1 -> findViewById(R.id.willchorando)
            2 -> findViewById(R.id.homerchorando)
            3 -> findViewById(R.id.patricktriste)
            4 -> findViewById(R.id.trumpsad)
            5 -> findViewById(R.id.theofficesad)
            else -> findViewById<GifImageView>(R.id.choro)
        }

        gif.visibility = View.VISIBLE

    }
}