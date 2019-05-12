package m.maja.cv

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUI()
    }

    private fun setUpUI()
    {
        buttonGenerateQuote.setOnClickListener { generateQuote() }
    }

    private fun generateQuote()
    {
        val quotes= resources.getStringArray(R.array.quoteArray)

        Toast.makeText(this,quotes[((0..9).random())],Toast.LENGTH_LONG).show()
    }
}
