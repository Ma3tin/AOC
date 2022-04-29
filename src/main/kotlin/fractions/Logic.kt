package fractions

import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(findGreatestCommonDenominator(8, 12))
}


fun findGreatestCommonDenominator(A: Int, B: Int): Int {
    val low = min(A, B)
    return (low downTo 1).first {i -> A % i == 0 && B % i == 0 }
}

fun findLowestCommonMultiple(A: Int, B: Int): Int {
    return if (A == 0 || B == 0) 0 else {
        val gcd: Int = findGreatestCommonDenominator(A, B)
        abs(A * B) / gcd
    }
}