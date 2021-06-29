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
    val calculateBoolean = MutableLiveData(false)
    private var number = BigDecimal(0.0)
    private val accuracyNumber = MutableLiveData(0)
    private val iteration = MutableLiveData(0)
    private val summaryBigDecimal = MutableLiveData(BigDecimal(0))

    fun setCalculateBoolean(boolean: Boolean) {
        calculateBoolean.postValue(boolean)
        if (boolean){
            piNum()
        }
    }

    fun getCalculateBoolean(): Boolean {
        return calculateBoolean.value ?: false
    }

    fun setAccuracyNumber(string: String) {
        accuracyNumber.value = string.toInt()
    }

    private fun piNum() {
        viewModelScope.launch(Dispatchers.Default) {
            var sum = getSummaryBigDecimal()
            var intNum: Int
            var intX = 0
            val numChar = getAccuracyNumber() + 2
            var i = getIterator()
            var pi = BigDecimal(0)
            while (getCalculateBoolean() && getPiString().length < numChar) {
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
            setIterator(i)
            setSummaryBigDecimal(sum)
            setPiString(sum.toString())
            setCalculateBoolean(false)
        }
    }

    private fun setSummaryBigDecimal(bigDecimal: BigDecimal) {
        summaryBigDecimal.postValue(bigDecimal)
    }

    private fun getSummaryBigDecimal(): BigDecimal {
        return summaryBigDecimal.value ?: BigDecimal(0)
    }

    private fun setIterator(int: Int) {
        iteration.postValue(int)
    }

    private fun getIterator(): Int {
        return iteration.value ?: 0
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

    private fun getAccuracyNumber(): Int {
        return accuracyNumber.value ?: 0
    }
}