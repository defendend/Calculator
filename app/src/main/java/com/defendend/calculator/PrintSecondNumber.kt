package com.defendend.calculator

class PrintSecondNumber {

    var secondNumber: String = ""
    var num2: Double? = 0.0

    var thereIsAPoint: Boolean = false

    fun addNum(string: String) {
        secondNumber += string
    }
    fun numDouble(){
        num2 = secondNumber.toDoubleOrNull()
    }

}