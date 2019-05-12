package m.maja.diceroller

import android.graphics.Color
import android.graphics.PorterDuff
import android.widget.Button


class Dice(
    private val firstDie: Button,
    private val secondDie: Button,
    private val thirdDie: Button,
    private val fourthDie: Button,
    private val fifthDie: Button,
    private val sixthDie: Button

)
{
    fun getAllDice():Array<Button>
    {
        return arrayOf(firstDie,secondDie,thirdDie,fourthDie,fifthDie,sixthDie)
    }

    fun enableDice(diceNumber: Int)
    {
        val currentButton= getButtonByDiceNumber(diceNumber)
        currentButton.isEnabled=true
    }

    fun changeDiceState(diceNumber:Int)
    {
        val currentButton = getButtonByDiceNumber(diceNumber)
        if(!currentButton.isActivated)
        {
            currentButton.isActivated=true
            val color = Color.parseColor("#A6A689D8")
            currentButton.background.setColorFilter(color, PorterDuff.Mode.LIGHTEN)
        }
        else
        {
            currentButton.background.clearColorFilter()
            currentButton.isActivated=false
        }
    }

    private fun getButtonByDiceNumber(diceNumber: Int): Button
    {
        return when(diceNumber)
        {
            0 -> firstDie
            1 -> secondDie
            2 -> thirdDie
            3 -> fourthDie
            4 -> fifthDie
            else -> sixthDie
        }
    }

}