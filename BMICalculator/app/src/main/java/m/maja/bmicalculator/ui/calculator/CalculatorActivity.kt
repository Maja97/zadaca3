package m.maja.bmicalculator.ui.calculator

import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_calculator.*
import m.maja.bmicalculator.R
import m.maja.bmicalculator.ui.model.BMI
import m.maja.bmicalculator.ui.result.ResultActivity
import m.maja.bmicalculator.ui.base.BaseActivity
import java.lang.Exception

class CalculatorActivity: BaseActivity() {
    override fun getLayoutResourceId():Int = R.layout.activity_calculator

    override fun setUpUI() {
        buttonCalculate.setOnClickListener { buttonOnClick() }
        calculatorActivityLayout.background.alpha= 150
    }

    private fun buttonOnClick() {
    try {

        val bmi=
            BMI(etWeight.text.toString().toDouble(), etHeight.text.toString().toDouble())

        val result = bmi.calculateBMI()

        navigateToResult(result)
    }
    catch (e: IllegalArgumentException) {
        Toast.makeText(this, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }
    catch (e: Exception) {
        Toast.makeText(this, "Wrong input", Toast.LENGTH_SHORT).show()
    }

}

    private fun navigateToResult(result: Double?) {
        val resultIntent = Intent(this, ResultActivity::class.java)
        resultIntent.putExtra(ResultActivity.EXTRA_RESULT, result)
        startActivity(resultIntent)
    }

}