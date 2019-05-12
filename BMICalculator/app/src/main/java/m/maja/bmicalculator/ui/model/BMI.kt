package m.maja.bmicalculator.ui.model

class BMI (
    private val weight: Double,
    private val height: Double
)
{
    fun calculateBMI(): Double
    {
        if(weight<=0||height<=0||weight>350||weight<20||height<1.2||height>2.5)
            throw IllegalArgumentException("Invalid numbers")
        return weight/(height*height)
    }
}