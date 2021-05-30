package com.defendend.calculator

class PrintFirstNumber {

    var firstNumber: String = "0"

    var thereIsAPoint: Boolean = false

    fun addNum(string: String) {
        firstNumber += string

    }

    fun numDouble() : Double{
       return firstNumber.toDoubleOrNull() ?: 0.0
    }
}