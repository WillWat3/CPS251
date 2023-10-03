package com.example.tipcalculatorproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.text.isDigitsOnly
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val output = findViewById<TextView>(R.id.tipOutput)
        val button = findViewById<Button>(R.id.myButton)
        val userInput = findViewById<TextInputEditText>(R.id.billInput)

        button.setOnClickListener{
            try {
                val input = userInput.text.toString().toInt()
                if (input >= 0) {

                    val ten = (input * 0.10) + input
                    val fifteen = (input * 0.15) + input
                    val twenty = (input * 0.20) + input
                    output.text =
                        "The tips are as follows: \n\n" + "Bill = $" + input + "\n" + "10% = $" + ten + "\n" + "15% = $" + fifteen + "\n" + "20% = $" + twenty + "\n"
                    userInput.text?.clear()
                }
            }
            catch(e:NumberFormatException){
                output.text = "PLEASE ENTER A VALID NUMERICAL VALUE"
                userInput.text?.clear()
            }
        }


    }
}