package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        val rollButton = binding.button
        rollButton.setOnClickListener { rollDice() }
    }

    fun rollDice() {
        val firstDice = Dice(6)
        val secondDice = Dice(6)

        val resultTextView1 = binding.textView1
        val resultTextView2 = binding.textView2
        resultTextView1.text = diceResult(1, firstDice.roll().toString())
        resultTextView2.text = diceResult(2, secondDice.roll().toString())
    }

    fun diceResult(diceIndex: Int, rolled: String): String {
        return " Dice $diceIndex rolled $rolled"
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}