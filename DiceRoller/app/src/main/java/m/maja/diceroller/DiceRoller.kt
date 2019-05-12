package m.maja.diceroller

class DiceRoller(
    private val dice: Dice,
    private val drawables:Map<Int,Int>
) {

    fun firstRoll()
    {
        val diceButtons= dice.getAllDice()
        for (diceButton in diceButtons) {
            diceButton.setBackgroundResource(drawables.getValue(getRandom()))
        }
    }

    fun secondRoll()
    {
        val diceButtons= dice.getAllDice()
        for (i in 0 until 6)
        {
            if (!diceButtons[i].isActivated)
                diceButtons[i].setBackgroundResource(drawables.getValue(getRandom()))
            diceButtons[i].isEnabled = false
            diceButtons[i].background.clearColorFilter()
            diceButtons[i].isActivated=false
        }
    }

    private  fun getRandom():Int
    {
        return (1..6).random()
    }

}