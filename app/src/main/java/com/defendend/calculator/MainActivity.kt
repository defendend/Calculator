package com.defendend.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val ONE: Int = 1

class MainActivity : AppCompatActivity() {

    private val numberOne = PrintFirstNumber()
    private val numberTwo = PrintSecondNumber()
    private val calculate = Calculate()
    private var operation: Boolean = false
    private var resultString: String=""
    private var equalls: Boolean=false
    private val chars: Array<Char> = arrayOf(' ', '+', '-', '÷', '*', '%','=')
    private var charNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun display() {
        displayExpression()
    }

    private fun displayExpression() {
        val expression = findViewById<TextView>(R.id.expression_text)
        expression.text = numberOne.firstNumber + chars[charNumber] + numberTwo.secondNumber
        if (equalls){
            expression.text = numberOne.firstNumber + chars[charNumber] + numberTwo.secondNumber + chars[6]
        }
    }

    fun nine(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.nine))
        } else {
            numberTwo.addNum(getString(R.string.nine))
        }
        display()
    }

    fun eight(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.eight))
        } else {
            numberTwo.addNum(getString(R.string.eight))
        }
        display()
    }

    fun seven(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.seven))
        } else {
            numberTwo.addNum(getString(R.string.seven))
        }
        display()
    }

    fun six(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.six))
        } else {
            numberTwo.addNum(getString(R.string.six))
        }
        display()
    }

    fun five(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.five))
        } else {
            numberTwo.addNum(getString(R.string.five))
        }
        display()
    }

    fun four(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.four))
        } else {
            numberTwo.addNum(getString(R.string.four))
        }
        display()
    }

    fun three(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.three))
        } else {
            numberTwo.addNum(getString(R.string.three))
        }
        display()
    }

    fun two(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.two))
        } else {
            numberTwo.addNum(getString(R.string.two))
        }
        display()
    }

    fun one(view: View) {
        if (numberOne.firstNumber.substring(0) == "0" && !numberOne.thereIsAPoint ){
            delete(view)
        }
        if (!operation) {
            numberOne.addNum(getString(R.string.one))
        } else {
            numberTwo.addNum(getString(R.string.one))
        }
        display()
    }

    fun zero(view: View) {
        if (!operation) {
            if (numberOne.firstNumber.substring(0) != "0") {
                numberOne.addNum(getString(R.string.zero))
            }
        } else {
            if (numberTwo.secondNumber.substring(0) != "0") {
                numberTwo.addNum(getString(R.string.zero))
            }
        }
        display()
    }

    fun doubleZero(view: View) {
        if (!operation) {
            if (numberOne.firstNumber.substring(0) != "0") {
                numberOne.addNum(getString(R.string.double_zero))
            }
        } else {
            if (numberTwo.secondNumber.substring(0) != "0") {
                numberTwo.addNum(getString(R.string.double_zero))
            }
        }
        display()
    }

    fun point(view: View) {
        if (!operation) {
            if (!numberOne.thereIsAPoint) {
                if (numberOne.firstNumber.isEmpty()){
                    numberOne.addNum(getString(R.string.zero))
                    numberOne.addNum(getString(R.string.point))
                    numberOne.thereIsAPoint = true
                }else {
                    numberOne.addNum(getString(R.string.point))
                    numberOne.thereIsAPoint = true
                }
            }
        } else {
            if (!numberTwo.thereIsAPoint) {
                if (numberTwo.secondNumber.isEmpty()){
                    numberTwo.addNum(getString(R.string.zero))
                    numberTwo.addNum(getString(R.string.point))
                    numberTwo.thereIsAPoint = true
                }else {
                    numberTwo.addNum(getString(R.string.point))
                    numberTwo.thereIsAPoint = true
                }
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
            } else {
                operation = false
                charNumber = 0
            }
        }
        display()
    }

    fun result(view: View) {
        equalls = true
        val result = findViewById<TextView>(R.id.result_text)
        resultString = calculate.calculate(numberOne.numDouble(), numberTwo.numDouble(), charNumber)
        result.text = resultString
        displayExpression()
        numberOne.firstNumber = resultString
        charNumber = 0
        equalls = false
        operation = false
        numberTwo.secondNumber = ""
    }

    fun plusNum(view: View) {
        if (numberTwo.secondNumber.isEmpty()) {
            charNumber = 1
            operation = true
            display()
        }
    }

    fun minusNum(view: View) {
        if (numberTwo.secondNumber.isEmpty()) {
            charNumber = 2
            operation = true
            display()
        }
    }


    fun division(view: View) {
        if (numberTwo.secondNumber.isEmpty()) {
            charNumber = 3
            operation = true
            display()
        }
    }

    fun multiplication(view: View) {
        if (numberTwo.secondNumber.isEmpty()) {
            charNumber = 4
            operation = true
            display()
        }

    }

    fun percent(view: View) {
        if (numberTwo.secondNumber.isEmpty()) {
            charNumber = 5
            operation = true
            result(view)
        }
    }

    fun clear(view: View) {
        operation = false
        numberOne.firstNumber = ""
        numberOne.thereIsAPoint = false
        numberTwo.secondNumber = ""
        numberTwo.thereIsAPoint = false
        val result = findViewById<TextView>(R.id.result_text)
        result.text = "0"
        val expression = findViewById<TextView>(R.id.expression_text)
        expression.text = "0"
        display()
    }


}