package com.defendend.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val firstNumber = MutableLiveData(Companion.ZERO_STRING)
    val secondNumber = MutableLiveData("")
    val result = MutableLiveData("")
    val expression = MutableLiveData("")
    val equals = MutableLiveData(false)
    private val calculate = Calculate()
    private var thereIsAPointFirst = false
    private var thereIsAPointSecond = false
    private var operation = false
    private var charNumber = 0

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
        private val chars: Array<Char> = arrayOf(' ', '+', '-', '÷', '*', '%')
    }

    init {
        setExpression()
        setResultString(Companion.ZERO_STRING)
    }


    private fun updateFirstString(string: String) {
        var str = getFirstString() + string
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
        var str = getSecondString() + string
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

    fun nine() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(NINE)
        } else {
            updateSecondString(NINE)
        }
    }

    fun eight() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(EIGHT)
        } else {
            updateSecondString(EIGHT)
        }
    }

    fun seven() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(SEVEN)
        } else {
            updateSecondString(SEVEN)
        }
    }

    fun six() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(SIX)
        } else {
            updateSecondString(SIX)
        }
    }

    fun five() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(FIVE)
        } else {
            updateSecondString(FIVE)
        }
    }

    fun four() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(FOUR)
        } else {
            updateSecondString(FOUR)
        }
    }

    fun three() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(THREE)
        } else {
            updateSecondString(THREE)
        }
    }

    fun two() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(TWO)
        } else {
            updateSecondString(TWO)
        }
    }

    fun one() {
        if (getFirstString().substring(ZERO) == Companion.ZERO_STRING && !thereIsAPointFirst) {
            delete()
        }
        if (!operation) {
            updateFirstString(ONE)
        } else {
            updateSecondString(ONE)
        }
    }

    fun zero() {
        if (!operation) {
            if (getFirstString().substring(ZERO) !== Companion.ZERO_STRING) {
                updateFirstString(Companion.ZERO_STRING)
            }
        } else {
            if (getSecondString().substring(ZERO) != Companion.ZERO_STRING) {
                updateSecondString(Companion.ZERO_STRING)
            }
        }
    }

    fun doubleZero() {
        if (getFirstString().isEmpty()) {
            updateFirstString(Companion.ZERO_STRING)
        }
        if (!operation) {
            if (getFirstString().substring(ZERO) != Companion.ZERO_STRING) {
                updateFirstString(DOUBLE_ZERO)
            }
        } else {
            if (getSecondString().substring(ZERO) != Companion.ZERO_STRING) {
                updateSecondString(DOUBLE_ZERO)
            }
        }
    }

    fun point() {
        if (!operation) {
            if (!thereIsAPointFirst) {
                thereIsAPointFirst = if (getFirstString().isEmpty()) {
                    updateFirstString(Companion.ZERO_STRING)
                    updateFirstString(Companion.POINT)
                    true
                } else {
                    updateFirstString(Companion.POINT)
                    true
                }
            }
        } else {
            if (!thereIsAPointSecond) {
                thereIsAPointSecond = if (getSecondString().isEmpty()) {
                    updateSecondString(Companion.ZERO_STRING)
                    updateSecondString(Companion.POINT)
                    true
                } else {
                    updateSecondString(Companion.POINT)
                    true
                }
            }
        }
    }

    fun delete() {
        var stringFirst = getFirstString()
        var stringSecond = getSecondString()
        if (!operation) {
            if (getFirstString().isNotEmpty()) {
                if (getFirstString().substring(getFirstString().length - ONE_INT) == Companion.POINT) {
                    thereIsAPointFirst = false
                }
                stringFirst = stringFirst.dropLast(ONE_INT)
                changeFirstString(stringFirst)
                setExpression()

            }
        } else {
            if (getSecondString().isNotEmpty()) {
                if (getSecondString().substring(getSecondString().length - ONE_INT) == Companion.POINT) {
                    thereIsAPointSecond = false
                }
                stringSecond = stringSecond.dropLast(ONE_INT)
                changeSecondString(stringSecond)
                setExpression()
            } else {
                operation = false
                charNumber = ZERO
                setExpression()
            }
        }
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
        changeFirstString(Companion.ZERO_STRING)
        thereIsAPointFirst = false
        changeSecondString("")
        thereIsAPointSecond = false
        setResultString(Companion.ZERO_STRING)
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

    fun handleOperation(charNum: Int) {
        if (getSecondString().isEmpty()) {
            charNumber = charNum
            setExpression()
            operation = true
        }
    }
}



