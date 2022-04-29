package fractions

import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(findGreatestCommonDenominator(8, 12))
}


fun findGreatestCommonDenominator(a: Int, b: Int): Int {
    val low = min(a, b)
    return (low downTo 1).first {i -> a % i == 0 && b % i == 0 }
}

fun findLowestCommonMultiple(a: Int, b: Int): Int {
    return if (a == 0 || b == 0) 0 else {
        val gcd: Int = findGreatestCommonDenominator(a, b)
        abs(a * b) / gcd
    }
}