package com.dijon.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val luckyNumber = 4

        var message = "fail"

        when (diceRoll) {
            //luckyNumber -> println("")
            1 -> message = "So sorry! You rolled a 1. Try again!"
            2 -> message = "Sadly, you rolled a 2. Try again!"
            3 -> message = "Unfortunately, you rolled a 3. Try again!"
            4 -> message = "You won!"
            5 -> message = "Don't cry! You rolled a 5. Try again!"
            6 -> message = "Apologies! you rolled a 6. Try again!"
        }

        // Update the screen with the dice roll
        val resultTextView: TextView = findViewById(R.id.textView)
        "$luckyNumber \n $message".also { resultTextView.text = it }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}