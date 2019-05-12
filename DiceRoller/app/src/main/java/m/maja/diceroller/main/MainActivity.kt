package m.maja.diceroller.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import m.maja.diceroller.Dice
import m.maja.diceroller.DiceRoller
import m.maja.diceroller.R

class MainActivity : AppCompatActivity() {

    private var firstRoll=true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUI()
    }

    private  fun setUpUI()
    {
        val dice= Dice(firstDie, secondDie, thirdDie, fourthDie, fifthDie, sixthDie)
        val drawables= getImages()
        val diceRoller= DiceRoller(dice, drawables)
        buttonFirstRoll.setOnClickListener {
            rollDice(dice,diceRoller)
        }
    }

    private fun rollDice(dice: Dice, diceRoller: DiceRoller)
    {
        if(firstRoll)
        {
            tvInstruction.visibility= View.VISIBLE

            val diceButtons= listOf<Button>(firstDie,secondDie,thirdDie,fourthDie,fifthDie,sixthDie)

            for(i in 0 until 6)
            {
                diceButtons[i].setOnClickListener{
                    dice.changeDiceState(i)
                }
                dice.enableDice(i)
            }

            diceRoller.firstRoll()
            firstRoll=false
        }

        else
        {
            tvInstruction.visibility = View.INVISIBLE

            diceRoller.secondRoll()
            firstRoll=true
        }
    }

    private fun getImages():Map<Int,Int>
    {
        return mapOf(
            1 to R.drawable.dice_1,
            2 to R.drawable.dice_2,
            3 to R.drawable.dice_3,
            4 to R.drawable.dice_4,
            5 to R.drawable.dice_5,
            6 to R.drawable.dice_6
        )
    }
}