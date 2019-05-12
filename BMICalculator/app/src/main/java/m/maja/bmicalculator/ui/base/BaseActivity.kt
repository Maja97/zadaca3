package m.maja.bmicalculator.ui.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import m.maja.bmicalculator.R

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        setUpUI()
    }

    abstract fun setUpUI()
    abstract fun getLayoutResourceId():Int
}
