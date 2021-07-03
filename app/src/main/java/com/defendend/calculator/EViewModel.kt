package com.defendend.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.math.BigInteger
import kotlin.math.pow

class EViewModel : ViewModel() {

    val eString = MutableLiveData("")
    val percent = MutableLiveData(0)
    val isCalculating = MutableLiveData(false)
    private var iteration: Int = 1
    private var number = BigDecimal(1)
    private var summaryBigDecimal = BigDecimal(1)
    private var accuracyNumber : Int = 0

    fun setIsCalculating(boolean: Boolean) {
        isCalculating.postValue(boolean)
        if (boolean) {
            calculateNumber()
        }
    }

    fun getIsCalculating(): Boolean {
        return isCalculating.value ?: false
    }

    fun setAccuracyNumber(numberEditText: String) {
        accuracyNumber = numberEditText.toInt()
    }

    private fun calculateNumber() {
        viewModelScope.launch(Dispatchers.Default) {
            var sum = summaryBigDecimal
            var intNum: Int
            var intX = 0
            val numChar = accuracyNumber + 2
            var n = iteration
            while (getIsCalculating() && getEString().length < numChar) {
                var fact = BigDecimal(1)
                for (i in 1..n) {
                    fact = fact.multiply(BigDecimal(1.0 / i))
                }
                number = fact
                sum = sum.plus(number)
                intNum = ((100.0 * getEString().length) / numChar).toInt()
                if (n % 100 == 0) {
                    setEString(sum.toString())
                }
                if (intNum > intX) {
                    intX = intNum
                    setPercent(intX)
                }
                n++
            }
            iteration = n
            summaryBigDecimal = sum
            setEString(sum.toString())
            setIsCalculating(false)
        }
    }

    private fun setEString(string: String) {
        eString.postValue(string)
    }

    private fun getEString(): String {
        return eString.value.toString()
    }

    private fun setPercent(int: Int) {
        percent.postValue(int)
    }
}