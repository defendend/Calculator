package com.defendend.calculator

class Calculate {


    fun calculate(double1: Double, double2: Double, numberChar: Int): String {
        return when (numberChar) {
            1 -> {
                plus(double1, double2)
            }
            2 -> {
                minus(double1, double2)
            }
            3 -> {
                division(double1, double2)
            }
            4 -> {
                multiplication(double1, double2)
            }
            5 -> {
                onePercent(double1)
            }
            else -> double1.toString()
        }

    }

    private fun plus(double1: Double, double2: Double): String {
        return (double1 + double2).toString()
    }

    private fun minus(double1: Double, double2: Double): String {
        return (double1 - double2).toString()
    }

    private fun division(double1: Double, double2: Double): String {
        return (double1 / double2).toString()
    }

    private fun multiplication(double1: Double, double2: Double): String {
        return (double1 * double2).toString()
    }

    private fun onePercent(double: Double): String {
        return (double / 100).toString()
    }

}