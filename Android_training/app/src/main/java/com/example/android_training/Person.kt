package com.example.android_training

open class Person(val name: String, val age: Int) {
    init {
        println(name + " is eating. He is " + age + " years old.")
    }
}