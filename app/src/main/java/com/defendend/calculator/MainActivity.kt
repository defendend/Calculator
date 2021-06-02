package com.defendend.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

private const val ONE: Int = 1
private const val ZERO_STRING: String = "0"
private const val POINT: String = "."
private const val ZERO: Int = 0

class MainActivity : AppCompatActivity() {

    private val number = PrintNumber()
    private val calculate = Calculate()
    private var operation: Boolean = false
    private var resultString: String = ""
    private var equalls: Boolean = false
    private val chars: Array<Char> = arrayOf(' ', '+', '-', '÷', '*', '%', '=')
    private var charNumber: Int = ZERO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun display() {
        displayExpression()
    }

    private fun displayExpression() {
        val expression = findViewById<TextView>(R.id.expression_text)
        expression.text = number.firstNumber + chars[charNumber] + number.secondNumber
        if (equalls) {
            expression.text =
                number.firstNumber + chars[charNumber] + number.secondNumber + chars[6]
        }
    }

    fun nine(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.nine))
        } else {
            number.addSecondNum(getString(R.string.nine))
        }
        display()
    }

    fun eight(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.eight))
        } else {
            number.addSecondNum(getString(R.string.eight))
        }
        display()
    }

    fun seven(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.seven))
        } else {
            number.addSecondNum(getString(R.string.seven))
        }
        display()
    }

    fun six(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.six))
        } else {
            number.addSecondNum(getString(R.string.six))
        }
        display()
    }

    fun five(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.five))
        } else {
            number.addSecondNum(getString(R.string.five))
        }
        display()
    }

    fun four(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.four))
        } else {
            number.addFirstNum(getString(R.string.four))
        }
        display()
    }

    fun three(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.three))
        } else {
            number.addSecondNum(getString(R.string.three))
        }
        display()
    }

    fun two(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.two))
        } else {
            number.addSecondNum(getString(R.string.two))
        }
        display()
    }

    fun one(view: View) {
        if (number.firstNumber.substring(ZERO) == ZERO_STRING && !number.thereIsAPointFirst) {
            delete(view)
        }
        if (!operation) {
            number.addFirstNum(getString(R.string.one))
        } else {
            number.addSecondNum(getString(R.string.one))
        }
        display()
    }

    fun zero(view: View) {
        if (!operation) {
            if (number.firstNumber.substring(ZERO) != ZERO_STRING) {
                number.addFirstNum(getString(R.string.zero))
            }
        } else {
            if (number.secondNumber.substring(ZERO) != ZERO_STRING) {
                number.addSecondNum(getString(R.string.zero))
            }
        }
        display()
    }

    fun doubleZero(view: View) {
        if (number.firstNumber.isEmpty()) {
            number.firstNumber = ZERO_STRING
        }
        if (!operation) {
            if (number.firstNumber.substring(ZERO) != ZERO_STRING) {
                number.addFirstNum(getString(R.string.double_zero))
            }
        } else {
            if (number.secondNumber.substring(ZERO) != ZERO_STRING) {
                number.addSecondNum(getString(R.string.double_zero))
            }
        }
        display()
    }

    fun point(view: View) {
        if (!operation) {
            if (!number.thereIsAPointFirst) {
                if (number.firstNumber.isEmpty()) {
                    number.addFirstNum(getString(R.string.zero))
                    number.addFirstNum(getString(R.string.point))
                    number.thereIsAPointFirst = true
                } else {
                    number.addFirstNum(getString(R.string.point))
                    number.thereIsAPointFirst = true
                }
            }
        } else {
            if (!number.thereIsAPointSecond) {
                if (number.secondNumber.isEmpty()) {
                    number.addSecondNum(getString(R.string.zero))
                    number.addSecondNum(getString(R.string.point))
                    number.thereIsAPointSecond = true
                } else {
                    number.addSecondNum(getString(R.string.point))
                    number.thereIsAPointSecond = true
                }
            }
        }
        display()
    }

    fun delete(view: View) {
        if (!operation) {
            if (number.firstNumber.isNotEmpty()) {
                if (number.firstNumber.substring(number.firstNumber.length - ONE) == POINT) {
                    number.thereIsAPointFirst = false
                }
                number.firstNumber = number.firstNumber.dropLast(ONE)
            }
        } else {
            if (number.secondNumber.isNotEmpty()) {
                if (number.secondNumber.substring(number.secondNumber.length - ONE) == POINT) {
                    number.thereIsAPointFirst = false
                }
                number.secondNumber = number.secondNumber.dropLast(ONE)
            } else {
                operation = false
                charNumber = ZERO
            }
        }
        display()
    }

    fun result(view: View) {
        equalls = true
        val result = findViewById<TextView>(R.id.result_text)
        resultString =
            calculate.calculate(number.numFirstDouble(), number.numSecondDouble(), charNumber)
        result.text = resultString
        displayExpression()
        number.firstNumber = resultString
        charNumber = ZERO
        equalls = false
        operation = false
        number.secondNumber = ""
    }

    private fun handleOperation(charNum: Int) {
        if (number.secondNumber.isEmpty()) {
            charNumber = charNum
            operation = true
            display()
        }
    }

    fun plusNum(view: View) {
        handleOperation(1)
    }

    fun minusNum(view: View) {
        handleOperation(2)
    }


    fun division(view: View) {
        handleOperation(3)
    }

    fun multiplication(view: View) {
        handleOperation(4)
    }

    fun percent(view: View) {
        handleOperation(5)
        result(view)
    }

    fun clear(view: View) {
        operation = false
        number.firstNumber = ""
        number.thereIsAPointFirst = false
        number.secondNumber = ""
        number.thereIsAPointSecond = false
        val result = findViewById<TextView>(R.id.result_text)
        result.text = ZERO_STRING
        val expression = findViewById<TextView>(R.id.expression_text)
        expression.text = ZERO_STRING
        display()
    }


}