package com.example.atividade_8_conversor_de_temperatura_desafio_extra

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val inputTemperatura = findViewById<EditText>(R.id.edTemperatura)
        val botaoCelsius = findViewById<RadioButton>(R.id.rbtnCelsius)
        val botaoFahrenheit = findViewById<RadioButton>(R.id.rbtnFahrenheit)
        val resposta = findViewById<TextView>(R.id.resposta)
        val botaoConverter = findViewById<Button>(R.id.btnConverter)

        val tem = DecimalFormat ("###.0")

        botaoConverter.setOnClickListener {

            val temperatura = inputTemperatura.text.toString()

            if (temperatura.isNotEmpty()){

                val tempDouble = temperatura.toDouble()

                if (botaoCelsius.isChecked) {

                    // Comvertendo de Fahrenheit para Celsius
                    val tempC: Double = (tempDouble - 32) * 5 / 9
                    resposta.setText("A temperatura em Celsius é: ${tem.format(tempC)}")

                }else if (botaoFahrenheit.isChecked){

                    // Convertendo de Celsius para Fahrenheit
                    val tempF: Double = (tempDouble * 9/5) + 32
                    resposta.setText("A temperatura em Fahrenheit é: ${tem.format(tempF)}")
                }else{
                    resposta.setText("Selesione o tipo de comverção desejado")
                }

            }else{
                resposta.setText("Insira a temperatura para comverção")
            }

        }

    }

    // Outra forma de criar função para o botão
    fun limparValores(view: View){
        val inputTemperatura = findViewById<EditText>(R.id.edTemperatura)
        val botaoCelsius = findViewById<RadioButton>(R.id.rbtnCelsius)
        val botaoFahrenheit = findViewById<RadioButton>(R.id.rbtnFahrenheit)
        val resposta = findViewById<TextView>(R.id.resposta)

        inputTemperatura.setText("")
        botaoCelsius.isChecked = false
        botaoFahrenheit.isChecked = false
        resposta.setText("")

    }
}