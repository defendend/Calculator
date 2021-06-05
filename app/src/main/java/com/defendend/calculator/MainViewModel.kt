package com.defendend.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val result = MutableLiveData("")
    val expression = MutableLiveData("")
    val equals = MutableLiveData(false)
    private val firstNumber = MutableLiveData(ZERO_STRING)
    private val secondNumber = MutableLiveData("")
    private val calculate = Calculate()
    private var thereIsAPointFirst = false
    private var thereIsAPointSecond = false
    private var operation = false
    private var charNumber = 0
    private val chars: Array<Char> = arrayOf(' ', '+', '-', '÷', '*', '%')

    init {
        setExpression()
        setResultString(ZERO_STRING)
    }

    fun nine() {
        numOperation(NINE)
    }

    fun eight() {
        numOperation(EIGHT)
    }

    fun seven() {
        numOperation(SEVEN)
    }

    fun six() {
        numOperation(SIX)
    }

    fun five() {
        numOperation(FIVE)
    }

    fun four() {
        numOperation(FOUR)
    }

    fun three() {
        numOperation(THREE)
    }

    fun two() {
        numOperation(TWO)
    }

    fun one() {
        numOperation(ONE)
    }

    fun zero() {
        zeroOperation(ZERO_STRING)
    }

    fun doubleZero() {
        if (getFirstString().isEmpty()) {
            updateFirstString(ZERO_STRING)
        }
        zeroOperation(DOUBLE_ZERO)
    }

    fun point() {
        firstPoint()
        secondPoint()
    }

    fun delete() {
        val stringFirst = getFirstString()
        val stringSecond = getSecondString()
        charInFirstString(stringFirst)
        charInSecondString(stringSecond)
    }

    fun result() {
        setEquals(true)
        setResultString(
            calculate.calculate(
                getFirstString().toDoubleOrZero(),
                getSecondString().toDoubleOrZero(),
                charNumber
            )
        )
        setExpression()
        changeFirstString(getResultString())
        charNumber = ZERO
        setEquals(false)
        operation = false
        changeSecondString(EMPTY_STRING)
    }

    fun clear() {
        operation = false
        setEquals(false)
        changeFirstString(ZERO_STRING)
        thereIsAPointFirst = false
        changeSecondString("")
        thereIsAPointSecond = false
        setResultString(ZERO_STRING)
        setExpression()
    }

    fun plusNum() {
        handleOperation(1)
    }

    fun minusNum() {
        handleOperation(2)
    }


    fun division() {
        handleOperation(3)
    }

    fun multiplication() {
        handleOperation(4)
    }

    fun percent() {
        handleOperation(5)
    }

    private fun updateFirstString(string: String) {
        val str = getFirstString() + string
        firstNumber.value = str
        setExpression()
    }

    private fun setResultString(string: String) {
        result.value = string
    }

    private fun getResultString(): String {
        return result.value.toString()
    }

    private fun MutableLiveData<Boolean>.toBoolean(): Boolean {
        return this.value ?: false
    }

    private fun setExpression() {
        if (!equals.toBoolean())
            expression.value = getFirstString() + chars[charNumber] + getSecondString()
        else {
            expression.value =
                getFirstString() + chars[charNumber] + getSecondString() + EQ_CHAR
        }
    }

    private fun updateSecondString(string: String) {
        val str = getSecondString() + string
        secondNumber.value = str
        setExpression()
    }

    private fun changeFirstString(string: String) {
        firstNumber.value = string
    }

    private fun changeSecondString(string: String) {
        secondNumber.value = string
    }

    private fun setEquals(boolean: Boolean) {
        equals.value = boolean
    }

    private fun getFirstString(): String {
        return firstNumber.value.toString()
    }


    private fun getSecondString(): String {
        return secondNumber.value.toString()
    }

    private fun String.toDoubleOrZero(): Double {
        return this.toDoubleOrNull() ?: 0.0
    }

    private fun handleOperation(charNum: Int) {
        if (getSecondString().isEmpty()) {
            charNumber = charNum
            setExpression()
            operation = true
        }
    }

    private fun charInFirstString(stringFirst: String) {
        if (!operation) {
            if (getFirstString().isNotEmpty()) {
                if (getFirstString().substring(getFirstString().length - ONE_INT) == POINT) {
                    thereIsAPointFirst = false
                }
                val str = stringFirst.dropLast(ONE_INT)
                changeFirstString(str)
                setExpression()

            }
        }
    }

    private fun charInSecondString(stringSecond: String) {
        if (operation) {
            if (getSecondString().isNotEmpty()) {
                if (getSecondString().substring(getSecondString().length - ONE_INT) == POINT) {
                    thereIsAPointSecond = false
                }
                val str = stringSecond.dropLast(ONE_INT)
                changeSecondString(str)
                setExpression()
            } else {
                operation = false
                charNumber = ZERO
                setExpression()
            }
        }
    }

    private fun firstPoint() {
        if (!operation) {
            if (!thereIsAPointFirst) {
                thereIsAPointFirst = if (getFirstString().isEmpty()) {
                    updateFirstString(ZERO_STRING)
                    updateFirstString(POINT)
                    true
                } else {
                    updateFirstString(POINT)
                    true
                }
            }
        }
    }

    private fun secondPoint() {
        if (operation) {
            if (!thereIsAPointSecond) {
                thereIsAPointSecond = if (getSecondString().isEmpty()) {
                    updateSecondString(ZERO_STRING)
                    updateSecondString(POINT)
                    true
                } else {
                    updateSecondString(POINT)
                    true
                }
            }
        }
    }

    private fun numOperation(currentValue: String) {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(currentValue)
        } else {
            updateSecondString(currentValue)
        }
    }

    private fun zeroOperation(currentValue: String) {
        if (!operation) {
            if (getFirstString().substring(ZERO) !== ZERO_STRING) {
                updateFirstString(currentValue)
            }
        } else {
            if (getSecondString().substring(ZERO) != ZERO_STRING) {
                updateSecondString(currentValue)
            }
        }
    }

    companion object {
        private const val ZERO: Int = 0
        private const val ONE_INT: Int = 1
        private const val EMPTY_STRING = ""
        private const val ZERO_STRING: String = "0"
        private const val DOUBLE_ZERO: String = "00"
        private const val ONE: String = "1"
        private const val TWO: String = "2"
        private const val THREE: String = "3"
        private const val FOUR: String = "4"
        private const val FIVE: String = "5"
        private const val SIX: String = "6"
        private const val SEVEN: String = "7"
        private const val EIGHT: String = "8"
        private const val NINE: String = "9"
        private const val EQ_CHAR = '='
        private const val POINT: String = "."
    }

}



