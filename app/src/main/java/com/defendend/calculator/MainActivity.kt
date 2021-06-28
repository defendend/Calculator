package com.defendend.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private val modelView: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initObserves()
    }

    fun advanced(view: View) {
        val intent = Intent(this@MainActivity, ActivityTwo::class.java)
        startActivity(intent)
    }


    private fun initObserves() {
        val expression = findViewById<TextView>(R.id.expression_text)
        val result = findViewById<TextView>(R.id.result_text)
        modelView.expression.observe(this) {
            expression.text = it
        }

        modelView.result.observe(this) {
            result.text = it
        }

    }

    fun nine(view: View) {
        modelView.nine()
    }

    fun eight(view: View) {
        modelView.eight()
    }

    fun seven(view: View) {
        modelView.seven()
    }

    fun six(view: View) {
        modelView.six()
    }

    fun five(view: View) {
        modelView.five()
    }

    fun four(view: View) {
        modelView.four()
    }

    fun three(view: View) {
        modelView.three()
    }

    fun two(view: View) {
        modelView.two()
    }

    fun one(view: View) {
        modelView.one()
    }

    fun zero(view: View) {
        modelView.zero()
    }

    fun doubleZero(view: View) {
        modelView.doubleZero()
    }

    fun point(view: View) {
        modelView.point()
    }

    fun delete(view: View) {
        modelView.delete()
    }

    fun result(view: View) {
        modelView.result()
    }


    fun plusNum(view: View) {
        modelView.plusNum()
    }

    fun minusNum(view: View) {
        modelView.minusNum()
    }


    fun division(view: View) {
        modelView.division()
    }

    fun multiplication(view: View) {
        modelView.multiplication()
    }

    fun percent(view: View) {
        modelView.percent()
        result(view)
    }

    fun clear(view: View) {
        modelView.clear()
    }


}