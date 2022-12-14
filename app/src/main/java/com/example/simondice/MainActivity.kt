package com.example.simondice

import android.annotation.SuppressLint
import android.media.Image

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var state : Boolean
        val button_red : ImageButton = findViewById(R.id.red)
        val button_yellow : ImageButton = findViewById(R.id.yellow)
        val button_blue : ImageButton = findViewById(R.id.blue)
        val button_green : ImageButton = findViewById(R.id.green)
        val button_start : Button = findViewById(R.id.start)

        button_start.setOnClickListener{
            iniciar()
            secuencia()
        }


    }


private fun iniciar(){
    Log.d("PARTIDA", "Empieza la partida")
    val puntuacionText: TextView = findViewById(R.id.puntuacion)

    val textRecord : TextView = findViewById(R.id.record)
    var secuencia : ArrayList<Int> = arrayListOf()

}
    private fun secuencia(){
        lateinit var secuencia: ArrayList<Int>
        var contador = 0
        var ronda = 1

        Log.d("JUEGO","Genera secuencia y la muestro  $ronda")
        var i=0


        while (i<ronda) {

            Log.d("JUEGO", "Comienza la secuencia")

            val numeroRandom = Random().nextInt(4)+1

            Log.d("JUEGO", "Nuevo color random generado $numeroRandom")
            Log.d("JUEGO", "Generado : $numeroRandom")

            secuencia.add(numeroRandom)

            mostrarColor(secuencia)
            i++
            Log.d("JUEGO","Secuencia $secuencia")
            Log.d("JUEGO", "Termina la secuencia")

        }

    }

    private fun mostrarColor(secuencia:ArrayList<Int>){
        var i=0
        var corutina: Job? = null
        corutina = GlobalScope.launch(Dispatchers.Main){
            while(i< secuencia.size){
                Log.d("JUEGO","Coroutina" +corutina.toString())

                val Button_red : ImageButton = findViewById(R.id.red)
                val Button_yellow : ImageButton = findViewById(R.id.yellow)
                val Button_blue : ImageButton = findViewById(R.id.blue)
                val Button_green : ImageButton = findViewById(R.id.green)

                delay(500L)
            when (secuencia[i]){
                1 -> Button_yellow.setImageResource(R.mipmap.ic_launcher)
                2 -> Button_blue.setImageResource(R.mipmap.ic_launcher)
                3 -> Button_green.setImageResource(R.mipmap.ic_launcher)
                else -> {
                    Button_red.setImageResource(R.mipmap.ic_launcher)
                }
            }
            delay(500L)
            Button_red.setImageResource(R.mipmap.ic_launcher)
            Button_yellow.setImageResource(R.mipmap.ic_launcher)
            Button_blue.setImageResource(R.mipmap.ic_launcher)
            Button_green.setImageResource(R.mipmap.ic_launcher)

            Log.d("JUEGO","El color nuevo se esta visualizando al jugador")
            i++
        }
    }
    val toast = Toast.makeText(applicationContext,"Pulsa",Toast.LENGTH_LONG)
    toast.show()
    }
    private fun compruebar(color: Int) {
        if(contador == secuencia.size) {
            val rondaSum = ronda + 1
            val rondaText: TextView = findViewById(R.id.puntuacion)
            rondaText.text = "Round : $rondaSum"

        }
        return if (color == secuencia[contador -1]){
            ronda ++

            miModelo.a??adirRonda(ronda)
            miModelo.livedata_ronda.observe(

            )
        }
    }


}

