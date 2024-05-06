package com.example.android_training

import java.lang.StringBuilder

fun String.lettersCount(): Int {
    var count = 0
    for (char in this)
        if (char.isLetter()) count++
    return count
}

operator fun String.times(n: Int): String = repeat(n)
