package com.example.android_training

class Money(val value: Int) {
    operator fun plus(money: Money): Money {
        val sum = value + money.value
        return Money(sum)
    }

    operator fun plus(newInt: Int): Money {
        val sum = value + newInt
        return Money(sum)
    }
}
