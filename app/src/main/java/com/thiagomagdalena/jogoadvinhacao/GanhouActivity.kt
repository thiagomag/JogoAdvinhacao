package com.thiagomagdalena.jogoadvinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import pl.droidsonroids.gif.GifImageView

class GanhouActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhou)

        val reiniciar = findViewById<Button>(R.id.recomecar)

        val bundle = intent.extras

        val pontos = findViewById<TextView>(R.id.pontos)
        pontos.text = bundle!!.getCharSequence("pontos")

        reiniciar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val gif = when ((1..6).random()) {
            1 -> findViewById(R.id.carlton)
            2 -> findViewById(R.id.bebe)
            3 -> findViewById(R.id.aceventura)
            4 -> findViewById(R.id.seinfeld)
            5 -> findViewById(R.id.theoffice)
            else -> findViewById<GifImageView>(R.id.yes)
        }

        gif.visibility = View.VISIBLE
    }
}
