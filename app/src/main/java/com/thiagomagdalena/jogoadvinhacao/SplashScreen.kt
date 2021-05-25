package com.thiagomagdalena.jogoadvinhacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ProgressBar
import android.widget.TextView

class SplashScreen : AppCompatActivity() {

    internal val TIME_OUT = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val titulo = findViewById<TextView>(R.id.txtTitulo)
        val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.bounce)
        titulo.startAnimation(animation)

        val prgBarHorizontal = findViewById<ProgressBar>(R.id.prgBar)

        var barStatus = 0
        Thread(Runnable {
            while(barStatus < 100){
                barStatus += 1

                try {
                    Thread.sleep(20)
                    prgBarHorizontal.progress = barStatus
                } catch (exp:InterruptedException) {
                    exp.printStackTrace()
                }
            }
        }).start()

        Handler().postDelayed(
            {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            },TIME_OUT.toLong())
    }
}