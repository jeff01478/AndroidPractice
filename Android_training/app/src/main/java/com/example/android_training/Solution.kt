package com.example.android_training

import java.lang.Exception
import java.util.LinkedList
import java.util.Stack

class Solution {
    fun good() {
        val good = Stack<String>()
        good.push("(")
        good.push(")")
        print(good.peek())
    }

    fun plusOne(digits: IntArray): IntArray {
        for (i in digits.size - 1 downTo 0) {
            if (digits[i] != 9) {
                digits[i] += 1
                return digits
            }
            digits[i] = 0
        }
        val newArray = IntArray(digits.size + 1)
        newArray[0] = 1
        return newArray
    }

    fun lengthOfLastWord(s: String): Int {
        var result = 0
        var index = s.length - 1
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ')
                result++
            else if (result > 0)
                return result
        }
        return result
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        var min = 0
        var max = nums.size - 1
        var index = 0
        while (max >= min) {
            index = (max + min) / 2
            if (target == nums[index])
                return index
            else if (target > nums[index]) {
                min = index + 1
                index++
            }
            else if (target < nums[index]) {
                max = index - 1
            }
            else
                break
        }
        return index
    }

    fun strStr(haystack: String, needle: String): Int {
        if (needle in haystack) {
            var sLength = needle.length
            for (i in 0..haystack.length - 1) {
                if (haystack.substring(i, sLength) == needle) {
                    return i
                }
                sLength++
            }
        }
        return -1
    }

    fun leastInterval(tasks: CharArray, n: Int): Int {
        if (n == 0)
            return tasks.size
        val array = tasks.toMutableList()
        val taskQueue = LinkedList<Char>()
        val arrayTemp = mutableListOf<Char>()
        var index = 0
        var result = 0
        while (true) {
            if (index > array.size - 1) {
                taskQueue.offer('0')
                if (taskQueue.size > n)
                    taskQueue.poll()
                result++
                index = 0
                continue
            }
            if (array[index] in taskQueue || array[index] in arrayTemp) {
                index++
                continue
            }
            taskQueue.offer(array[index])
            arrayTemp.add(array[index])
            if (array.subtract(arrayTemp.toSet()).isEmpty())
                arrayTemp.clear()
            array.removeAt(index)
            if (taskQueue.size > n)
                taskQueue.poll()
            result++
            index = 0
            if (array.isEmpty())
                return result
        }
    }

    fun isValid(s: String): Boolean {
        if(s.length % 2 == 1)
            return false
        val openBracket = setOf('(', '[', '{')
        val brackets = setOf("()", "[]", "{}")
        val bracketTemp = Stack<Char>()
        s.toCharArray().forEach {
            if (it in openBracket)
                bracketTemp.push(it)
            else {
                if (bracketTemp.isEmpty())
                    return false
                if ("" + bracketTemp.pop() + it !in brackets)
                    return false
            }
        }
        return bracketTemp.isEmpty()
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 1)
            return strs[0]
        var result = ""
        var j = 0
        while (true) {
            try {
                for (i in 0..strs.size - 2) {
                    if (strs[0][j] != strs[i+1][j])
                        return result
                }
            } catch (e: Exception) {
                return result
            }
            result += strs[0][j]
            j++
        }
    }

    fun romanToInt(s: String): Int {
        val number = arrayListOf<Int>()
        number.apply {
            for (i in s) {
                when(i) {
                    'I' -> add(1)
                    'V' -> add(5)
                    'X' -> add(10)
                    'L' -> add(50)
                    'C' -> add(100)
                    'D' -> add(500)
                    'M' -> add(1000)
                }
            }
            add(0)
        }
        var romanToNum = 0
        var step = false
        for (i in 0..number.size - 1) {
            if (number[i] == 0)
                break
            if (step) {
                step = false
                continue
            }
            if (number[i] >= number[i+1]) {
                romanToNum += number[i]
            } else {
                romanToNum += number[i+1] - number[i]
                step = true
            }
        }
        return romanToNum
    }

    fun isPalindrome(x: Int): Boolean {
        val num = x.toString()
        val first = 0
        val last = num.length - 1
        var i = 0
        while (first + i < last - i) {
            if (num[first + i] != num[last - i])
                return false
            i++
        }
        return true
    }
}