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
        rollDice()
    }

    private fun rollDice() {
        val firstDice = Dice(6)
        val rollFirstDice = firstDice.roll()
        val secondDice = Dice(6)
        val rollSecondDice = secondDice.roll()

        /** Display Dice  with the image corresponding to a random Number
          Add content descriptio for accessibility users**/
        val diceImage1 = binding.imageView1
        diceImage1.setImageResource(diceImageShow(rollFirstDice))
        diceImage1.contentDescription = rollFirstDice.toString()

        val diceImage2 = binding.imageView2
        diceImage2.setImageResource(diceImageShow(rollSecondDice))
        diceImage1.contentDescription = rollSecondDice.toString()

    }

    private fun diceImageShow(rolledDice: Int): Int {
        return when (rolledDice) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}