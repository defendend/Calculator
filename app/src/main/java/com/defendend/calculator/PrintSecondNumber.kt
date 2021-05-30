package com.defendend.calculator

class PrintSecondNumber {

    var secondNumber: String = ""

    var thereIsAPoint: Boolean = false

    fun addNum(string: String) {
        secondNumber += string
    }

    fun numDouble() : Double{
        return secondNumber.toDoubleOrNull() ?: 0.0
    }

}