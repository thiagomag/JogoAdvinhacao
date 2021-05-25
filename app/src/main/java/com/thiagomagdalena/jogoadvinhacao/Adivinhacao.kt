package com.thiagomagdalena.jogoadvinhacao

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Adivinhacao : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advinhacao)

        chute()

    }

    @SuppressLint("SetTextI18n")
    private fun chute() {

        val chute = findViewById<EditText>(R.id.chute)
        val btnChute = findViewById<Button>(R.id.btnChute)
        val numeroSecreto = (0..100).random().toString()

        val bundle = intent.extras

        var pontos = 1000

        var tentativas = when (bundle!!.getCharSequence("dificuldade")) {
            "Difícil" -> 5
            "Médio" -> 10
            else -> 20
        }


        btnChute.setOnClickListener OnClickListener@{
            val numeroChute = chute.text.toString()

            if (TextUtils.isEmpty((chute.text.toString()))) {
                chute.error = "Dê o seu chute"
                return@OnClickListener
            } else if(numeroChute.toInt() !in 0..100) {
                    chute.error = "Chute entre 0 e 100"
                    return@OnClickListener
            }

            val texto = findViewById<TextView>(R.id.resultado)

            bundle.putString("pontos", pontos.toString())

            when {
                numeroChute == numeroSecreto -> {
                    pontos -= (numeroSecreto.toInt() - numeroChute.toInt())
                    val intent = Intent(this, GanhouActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                numeroChute > numeroSecreto -> {
                    pontos -= -1 * (numeroSecreto.toInt() - numeroChute.toInt())
                    tentativas -= 1
                    if (tentativas == 0) {
                        val intent = Intent(this, PerdeuActivity::class.java)
                        startActivity(intent)
                    }
                    texto.text =
                        "Você errou! O seu chute foi maior do que o número secreto. ${tentativas} restantes"

                }
                numeroChute < numeroSecreto -> {
                    pontos -= (numeroSecreto.toInt() - numeroChute.toInt())
                    tentativas -= 1
                    if (tentativas == 0) {
                        val intent = Intent(this, PerdeuActivity::class.java)
                        startActivity(intent)
                    }
                    texto.text =
                        "Você errou! O seu chute foi menor do que o número secreto. ${tentativas} restantes"
                }
            }
        }
    }
}