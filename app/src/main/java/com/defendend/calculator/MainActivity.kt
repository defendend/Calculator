package com.defendend.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

private const val ONE: Int = 1

class MainActivity : AppCompatActivity() {

    private val numberOne = PrintFirstNumber()
    private val numberTwo = PrintSecondNumber()
    private var operation: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun display() {
        displayExpression()
    }

    private fun displayExpression() {
        val expression = findViewById<TextView>(R.id.expression_text)
        expression.text = numberOne.firstNumber + " " + numberTwo.secondNumber
    }

    fun nine(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.nine))
        } else {
            numberTwo.addNum(getString(R.string.nine))
        }
        display()
    }

    fun eight(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.eight))
        } else {
            numberTwo.addNum(getString(R.string.eight))
        }
        display()
    }

    fun seven(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.seven))
        } else {
            numberTwo.addNum(getString(R.string.seven))
        }
        display()
    }

    fun six(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.six))
        } else {
            numberTwo.addNum(getString(R.string.six))
        }
        display()
    }

    fun five(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.five))
        } else {
            numberTwo.addNum(getString(R.string.five))
        }
        display()
    }

    fun four(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.four))
        } else {
            numberTwo.addNum(getString(R.string.four))
        }
        display()
    }

    fun three(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.three))
        } else {
            numberTwo.addNum(getString(R.string.three))
        }
        display()
    }

    fun two(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.two))
        } else {
            numberTwo.addNum(getString(R.string.two))
        }
        display()
    }

    fun one(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.one))
        } else {
            numberTwo.addNum(getString(R.string.one))
        }
        display()
    }

    fun zero(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.zero))
        } else {
            numberTwo.addNum(getString(R.string.zero))
        }
        display()
    }

    fun doubleZero(view: View) {
        if (!operation) {
            numberOne.addNum(getString(R.string.double_zero))
        } else {
            numberTwo.addNum(getString(R.string.double_zero))
        }
        display()
    }

    fun point(view: View) {
        if (!operation) {
            if (!numberOne.thereIsAPoint) {
                numberOne.addNum(getString(R.string.point))
                numberOne.thereIsAPoint = true
            }
        } else {
            if (!numberTwo.thereIsAPoint) {
                numberTwo.addNum(getString(R.string.point))
                numberTwo.thereIsAPoint = true
            }
        }
        display()
    }

    fun delete(view: View) {
        if (!operation) {
            if (numberOne.firstNumber.isNotEmpty()) {
                if (numberOne.firstNumber.substring(numberOne.firstNumber.length - ONE) == ".") {
                    numberOne.thereIsAPoint = false
                }
                numberOne.firstNumber = numberOne.firstNumber.dropLast(ONE)
            }
        } else {
            if (numberTwo.secondNumber.isNotEmpty()) {
                if (numberTwo.secondNumber.substring(numberTwo.secondNumber.length - ONE) == ".") {
                    numberTwo.thereIsAPoint = false
                }
                numberTwo.secondNumber = numberTwo.secondNumber.dropLast(ONE)
            }
        }
        display()
    }

    fun result(view: View) {
        val result = findViewById<TextView>(R.id.result_text)
        numberOne.numDouble()
        numberTwo.numDouble()
        result.text = ""
    }

}