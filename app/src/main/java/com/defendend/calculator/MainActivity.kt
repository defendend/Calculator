package com.defendend.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

private const val EQ_CHAR = '='

class MainActivity : AppCompatActivity() {

    private var modelView = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modelView = ViewModelProvider(this).get(MainViewModel::class.java)
        display()
    }


    private fun display() {
        val expression = findViewById<TextView>(R.id.expression_text)
        val result = findViewById<TextView>(R.id.result_text)
        modelView.expression.observe(this, Observer {
            expression.text = it
        })

        modelView.result.observe(this, Observer {
            result.text = it
        })

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