package com.example.simondice

import android.annotation.SuppressLint

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import java.util.*


class MainActivity : AppCompatActivity() {

    var secuencia: ArrayList<Int> = arrayListOf()
    var ronda: Int = 0
    var record: Int = 0

    lateinit var buttonStart: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonStart = findViewById(R.id.button)
        buttonStart.setOnClickListener {
            iniciarPartida()
            generarSecuencia()
        }

    }

    private fun iniciarPartida() {
        Log.d("JUEGO", "PARTIDA: Comienza la partida")
        Log.d("JUEGO", "PARTIDA: Ronda = $ronda")
        // TODO inicializar array de secuencia
        ronda++
    }

    private fun generarSecuencia(){
        Log.d("JUEGO","Genero secuencia y muestro " + ronda.toString())
        var i = 0
        while (i < ronda) {
            Log.d("JUEGO", "SECUENCIA: Comienza la secuencia")
            mostrarSecuencia()
            i++
            Log.d("JUEGO", "SECUENCIA: Termina la secuencia")
        }
    }

    private fun mostrarSecuencia() {
        val numeroRandom = Random().nextInt(4) + 1

        Log.d("JUEGO", "COLOR: Nuevo color random generado " + numeroRandom.toString())
        secuencia.add(numeroRandom)
        val ButtonY: ImageButton = findViewById(R.id.imageButton2)
        val ButtonG: ImageButton = findViewById(R.id.imageButton4)
        val ButtonB: ImageButton = findViewById(R.id.imageButton5)
        val ButtonR: ImageButton = findViewById(R.id.imageButton6)

        Log.d("JUEGO", "Generado: " + numeroRandom.toString() )

        when (numeroRandom) {
            1 -> ButtonY.setImageResource(R.drawable.ic_launcher_background)
            2 -> ButtonG.setImageResource(R.drawable.ic_launcher_background)
            3 -> ButtonB.setImageResource(R.drawable.ic_launcher_background)
            else -> {
                ButtonR.setImageResource(R.drawable.ic_launcher_background)
            }
        }

        var corutina: Job? = null
        corutina = GlobalScope.launch(Dispatchers.Main){
            Log.d("JUEGO", "Coroutina" + corutina.toString())
            delay(1000L)
        }

        ButtonY.setImageResource(R.drawable.ic_launcher_background)
        ButtonG.setImageResource(R.drawable.ic_launcher_background)
        ButtonB.setImageResource(R.drawable.ic_launcher_background)
        ButtonR.setImageResource(R.drawable.ic_launcher_background)

        Log.d("JUEGO", "COLOR: Nuevo color visualizado al jugador")

    }


}