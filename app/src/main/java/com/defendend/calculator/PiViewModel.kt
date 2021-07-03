package com.defendend.calculator

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal
import kotlin.math.pow
import kotlin.math.sqrt

class PiViewModel : ViewModel() {

    val piString = MutableLiveData("")
    val percent = MutableLiveData(0)
    val isCalculating = MutableLiveData(false)
    private var number = BigDecimal(0.0)
    private var accuracyNumber : Int = 0
    private var iteration : Int = 0
    private var summaryBigDecimal = BigDecimal(0)

    fun setIsCalculating(isCalculate: Boolean) {
        isCalculating.postValue(isCalculate)
        if (isCalculate){
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
            var i = iteration
            var pi = BigDecimal(0)
            while (getIsCalculating() && getPiString().length < numChar) {
                pi = BigDecimal(sqrt(3.0)).multiply(BigDecimal(2.0* (-1.0).pow(1.0 * i)))
                number = pi.multiply(BigDecimal(((1.0/(2*i+1))*(1.0/((3.0).pow(1.0*i)))) ))
                sum = sum.plus(number)
                intNum = ((100.0 * getPiString().length) / numChar).toInt()
                if (i%100 == 0) {
                    setPiString(sum.toString())
                }
                if (intNum > intX) {
                    intX = intNum
                    setPercent(intX)
                }
                i++
            }
            iteration = i
            summaryBigDecimal = sum
            setPiString(sum.toString())
            setIsCalculating(false)
        }
    }

    private fun setPiString(string: String) {
        piString.postValue(string)
    }

    private fun getPiString(): String {
        return piString.value.toString()
    }

    private fun setPercent(int: Int) {
        percent.postValue(int)
    }
}