package com.example.android_training

import java.lang.Integer.max
import kotlin.text.StringBuilder

var content: String? = "hello"

fun main() {
    val array = intArrayOf(1,2,3)
    val good = Solution()
    print(good.plusOne(array))
}

fun getRandomLengthString(str: String) = str * (1..20).random()

fun printUpperCase() {
    val upperCase = content!!.uppercase()
    println(upperCase)
}

fun doStudy(study: Study?) {
    study?.let {
        with(it) {
            readBooks()
            doHomework()
        }
    }
}

fun getTextLength(text: String?) = text?.length ?: 0

fun largerNumber(num1: Int, num2: Int): Int = if (num1 > num2) num1 else num2
fun getScore(name: String) = when(name){
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
    else -> 0
}

fun checkNumber(num: Number) {
    when(num) {
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not support")
    }
}

class test : Study {
    override fun readBooks() {

    }
}
