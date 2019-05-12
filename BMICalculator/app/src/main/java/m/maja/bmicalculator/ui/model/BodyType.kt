package m.maja.bmicalculator.ui.model

import m.maja.bmicalculator.R

enum class BodyType {
    UNDERWEIGHT, NORMAL, OVERWEIGHT, OBESE, EXTREMELY_OBESE;


    companion object {
        fun getAllResources(bodyType: BodyType): Array<Int> {
            return when (bodyType) {
                UNDERWEIGHT -> arrayOf(R.drawable.underweight,R.string.underweight_name,R.string.underweight_description,R.drawable.underweight_background)
                NORMAL -> arrayOf(R.drawable.normal,R.string.normal_name,R.string.normal_description,R.drawable.normal_background)
                OVERWEIGHT -> arrayOf(R.drawable.overweight,R.string.overweight_name,R.string.overweight_description,R.drawable.overweight_background)
                OBESE -> arrayOf(R.drawable.obese,R.string.obese_name,R.string.obese_description,R.drawable.obese_background)
                else -> arrayOf(R.drawable.extremely_obese,R.string.extremely_obese_name,R.string.extremely_obese_description,R.drawable.extremely_obese_background)
            }
        }
    }
}