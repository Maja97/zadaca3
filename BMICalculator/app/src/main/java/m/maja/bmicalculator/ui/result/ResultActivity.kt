package m.maja.bmicalculator.ui.result

import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_result.*
import m.maja.bmicalculator.R
import m.maja.bmicalculator.ui.model.BodyType
import m.maja.bmicalculator.ui.base.BaseActivity

class ResultActivity : BaseActivity() {

    companion object {
        const val EXTRA_RESULT = "EXTRA_RESULT"
        const val NO_RESULT = -1.0
    }

    override fun getLayoutResourceId(): Int = R.layout.activity_result

    override fun setUpUI() {

        tvResultDescription.movementMethod= ScrollingMovementMethod()

        val result = intent.getDoubleExtra(
            EXTRA_RESULT,
            NO_RESULT
        )
            showResults(result)
    }

    private fun showResults(result: Double)
    {
        val bodyType= when(result)
        {
            in 0.0..18.5 -> BodyType.UNDERWEIGHT
            in 18.5..25.0 -> BodyType.NORMAL
            in 25.0..30.0 -> BodyType.OVERWEIGHT
            in 30.0..35.0 -> BodyType.OBESE
            else -> BodyType.EXTREMELY_OBESE
        }


        tvResultNumber.text=getString(R.string.twoDecimalPlaces).format(result)
        val allResources= BodyType.getAllResources(bodyType)
        personSilhouette.setImageResource(allResources[0])

        tvResultName.setText(allResources[1])
        tvResultDescription.setText(allResources[2])
        resultActivityLayout.setBackgroundResource(allResources[3])

    }
}
