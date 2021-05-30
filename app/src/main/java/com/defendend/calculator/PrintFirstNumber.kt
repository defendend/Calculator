package com.defendend.calculator

class PrintFirstNumber {

    var firstNumber: String = ""
    var num1: Double? = 0.0

    var thereIsAPoint: Boolean = false

    fun addNum(string: String) {
        firstNumber += string

    }

    fun numDouble(){
        num1 = firstNumber.toDoubleOrNull()
    }
}