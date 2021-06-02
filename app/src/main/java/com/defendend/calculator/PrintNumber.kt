package com.defendend.calculator

data class PrintNumber(

    var firstNumber: String = "0",

    var thereIsAPointFirst: Boolean = false,

    var secondNumber: String = "",

    var thereIsAPointSecond: Boolean = false
) {

    fun addFirstNum(string: String) {
        firstNumber += string

    }

    fun numFirstDouble(): Double {
        return firstNumber.toDoubleOrNull() ?: 0.0
    }

    fun addSecondNum(string: String) {
        secondNumber += string

    }

    fun numSecondDouble(): Double {
        return secondNumber.toDoubleOrNull() ?: 0.0
    }
}