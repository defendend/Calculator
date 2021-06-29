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
    val calculateBoolean = MutableLiveData(false)
    private var number = BigDecimal(1)
    private val accuracyNumber = MutableLiveData(0)
    private val iteration = MutableLiveData(1)
    private val summaryBigDecimal = MutableLiveData(BigDecimal(1))

    fun setCalculateBoolean(boolean: Boolean) {
        calculateBoolean.value = boolean
        if (boolean){
            eNum()
        }
    }

    fun getCalculateBoolean(): Boolean {
        return calculateBoolean.value ?: false
    }

    fun setAccuracyNumber(string: String) {
        accuracyNumber.value = string.toInt()
    }

    private fun eNum(){
        viewModelScope.launch(Dispatchers.Default){
            var sum = getSummaryBigDecimal()
            var intNum: Int
            var intX = 0
            val numChar = getAccuracyNumber() + 2
            var n = getIterator()
            while (getCalculateBoolean() && getEString().length < numChar) {
                var fact = BigDecimal(1)
                for (i in 1..n){
                    fact = fact.multiply(BigDecimal(1.0/i))
                }
                number = fact
                sum = sum.plus(number)
                intNum = ((100.0 * getEString().length) / numChar).toInt()
                if (n%100 == 0) {
                    setEString(sum.toString())
                }
                if (intNum > intX) {
                    intX = intNum
                    setPercent(intX)
                }
                n++
            }
            setIterator(n)
            setSummaryBigDecimal(sum)
            setEString(sum.toString())
            setCalculateBoolean(false)
        }
    }

    private fun setEString(string: String){
        eString.postValue(string)
    }

    private fun getEString() : String{
        return eString.value.toString()
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

    private fun setPercent(int: Int) {
        percent.postValue(int)
    }

    private fun getAccuracyNumber(): Int {
        return accuracyNumber.value ?: 0
    }

}