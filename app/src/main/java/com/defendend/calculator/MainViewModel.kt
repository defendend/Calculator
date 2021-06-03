package com.defendend.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


private const val ZERO_STRING: String = "0"
private const val POINT: String = "."
private const val ZERO: Int = 0
private const val EMPTY_STRING = ""
private const val ONE_INT: Int = 1
private const val ONE: String = "1"
private const val TWO: String = "2"
private const val THREE: String = "3"
private const val FOUR: String = "4"
private const val FIVE: String = "5"
private const val SIX: String = "6"
private const val SEVEN: String = "7"
private const val EIGHT: String = "8"
private const val NINE: String = "9"
private const val DOUBLE_ZERO: String = "00"
private val chars: Array<Char> = arrayOf(' ', '+', '-', '÷', '*', '%')
private const val EQ_CHAR = '='


class MainViewModel : ViewModel() {

    val firstNumber = MutableLiveData(ZERO_STRING)
    val secondNumber = MutableLiveData("")
    val result = MutableLiveData("")
    val expression = MutableLiveData("")
    val thereIsAPointFirst = MutableLiveData(false)
    val thereIsAPointSecond = MutableLiveData(false)
    val operation = MutableLiveData(false)
    val charNumber = MutableLiveData(0)
    val equals = MutableLiveData(false)
    private val calculate = Calculate()

    init {
        setExpression()
        setResultString(ZERO_STRING)
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
            expression.value = getFirstString() + chars[getCharNumber()] + getSecondString()
        else {
            expression.value =
                getFirstString() + chars[getCharNumber()] + getSecondString() + EQ_CHAR
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

    private fun setCharNumber(int: Int) {
        charNumber.value = int
    }

    private fun setEquals(boolean: Boolean) {
        equals.value = boolean
    }

    private fun setThereIsAPointFirst(boolean: Boolean) {
        thereIsAPointFirst.value = boolean
    }

    private fun setThereIsAPointSecond(boolean: Boolean) {
        thereIsAPointSecond.value = boolean
    }

    private fun setOperation(boolean: Boolean) {
        operation.value = boolean
    }

    private fun getFirstString(): String {
        return firstNumber.value.toString()
    }


    private fun getSecondString(): String {
        return secondNumber.value.toString()
    }

    private fun getCharNumber(): Int {
        return charNumber.value ?: 0
    }

    private fun String.toDoubleOrZero(): Double {
        return this.toDoubleOrNull() ?: 0.0
    }

    fun nine() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(NINE)
        } else {
            updateSecondString(NINE)
        }
    }

    fun eight() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(EIGHT)
        } else {
            updateSecondString(EIGHT)
        }
    }

    fun seven() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(SEVEN)
        } else {
            updateSecondString(SEVEN)
        }
    }

    fun six() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(SIX)
        } else {
            updateSecondString(SIX)
        }
    }

    fun five() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(FIVE)
        } else {
            updateSecondString(FIVE)
        }
    }

    fun four() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(FOUR)
        } else {
            updateSecondString(FOUR)
        }
    }

    fun three() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(THREE)
        } else {
            updateSecondString(THREE)
        }
    }

    fun two() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(TWO)
        } else {
            updateSecondString(TWO)
        }
    }

    fun one() {
        if (getFirstString().substring(ZERO) == ZERO_STRING && !thereIsAPointFirst.toBoolean()) {
            delete()
        }
        if (!operation.toBoolean()) {
            updateFirstString(ONE)
        } else {
            updateSecondString(ONE)
        }
    }

    fun zero() {
        if (!operation.toBoolean()) {
            if (getFirstString().substring(ZERO) !== ZERO_STRING) {
                updateFirstString(ZERO_STRING)
            }
        } else {
            if (getSecondString().substring(ZERO) != ZERO_STRING) {
                updateSecondString(ZERO_STRING)
            }
        }
    }

    fun doubleZero() {
        if (getFirstString().isEmpty()) {
            updateFirstString(ZERO_STRING)
        }
        if (!operation.toBoolean()) {
            if (getFirstString().substring(ZERO) != ZERO_STRING) {
                updateFirstString(DOUBLE_ZERO)
            }
        } else {
            if (getSecondString().substring(ZERO) != ZERO_STRING) {
                updateSecondString(DOUBLE_ZERO)
            }
        }
    }

    fun point() {
        if (!operation.toBoolean()) {
            if (!thereIsAPointFirst.toBoolean()) {
                if (getFirstString().isEmpty()) {
                    updateFirstString(ZERO_STRING)
                    updateFirstString(POINT)
                    setThereIsAPointFirst(true)
                } else {
                    updateFirstString(POINT)
                    setThereIsAPointFirst(true)
                }
            }
        } else {
            if (!thereIsAPointSecond.toBoolean()) {
                if (getSecondString().isEmpty()) {
                    updateSecondString(ZERO_STRING)
                    updateSecondString(POINT)
                    setThereIsAPointSecond(true)
                } else {
                    updateSecondString(POINT)
                    setThereIsAPointSecond(true)
                }
            }
        }
    }

    fun delete() {
        var stringFirst = getFirstString()
        var stringSecond = getSecondString()
        if (!operation.toBoolean()) {
            if (getFirstString().isNotEmpty()) {
                if (getFirstString().substring(getFirstString().length - ONE_INT) == POINT) {
                    setThereIsAPointFirst(false)
                }
                stringFirst = stringFirst.dropLast(ONE_INT)
                changeFirstString(stringFirst)
                setExpression()

            }
        } else {
            if (getSecondString().isNotEmpty()) {
                if (getSecondString().substring(getSecondString().length - ONE_INT) == POINT) {
                    setThereIsAPointSecond(false)
                }
                stringSecond = stringSecond.dropLast(ONE_INT)
                changeSecondString(stringSecond)
                setExpression()
            } else {
                setOperation(false)
                setCharNumber(ZERO)
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
                getCharNumber()
            )
        )
        setExpression()
        changeFirstString(getResultString())
        setCharNumber(ZERO)
        setEquals(false)
        setOperation(false)
        changeSecondString(EMPTY_STRING)
    }

    fun clear() {
        setOperation(false)
        setEquals(false)
        changeFirstString(ZERO_STRING)
        setThereIsAPointFirst(false)
        changeSecondString("")
        setThereIsAPointSecond(false)
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

    fun handleOperation(charNum: Int) {
        if (getSecondString().isEmpty()) {
            setCharNumber(charNum)
            setExpression()
            setOperation(true)
        }
    }
}



