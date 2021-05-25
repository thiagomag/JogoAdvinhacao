package com.thiagomagdalena.jogoadvinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComecar = findViewById<Button>(R.id.btnComecar)

        val dificuldade = findViewById<RadioGroup>(R.id.dificuldade)

        btnComecar.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, Adivinhacao::class.java)

            val bundle = Bundle()

            val difId = dificuldade.checkedRadioButtonId

            if(difId == -1){
                Toast.makeText(this, "Escolha a dificuldade", Toast.LENGTH_LONG).show()
                return@OnClickListener
            } else {
                val radioButton = findViewById<RadioButton>(difId)
                val dif = radioButton.text.toString()
                bundle.putString("dificuldade", dif)
            }
            intent.putExtras(bundle)

            startActivity(intent)
        })
    }
}