package fractions

fun main() {
    println(findGreatestCommonDenominator(8, 12))
}


fun findGreatestCommonDenominator(A: Int, B: Int): Int {
    var low = 0
    var high = 0
    if (A < B) {
        low = A
        high = B
    } else {
        low = B
        high = A
    }

    for (i in low downTo 1) {
        if (A % i == 0 && B % i == 0) return i
    }
    return 1
}

fun findLowestCommonMultiple(A: Int, B: Int): Int {
    var low = 0
    var high = 0
    if (A < B) {
        low = A
        high = B
    } else {
        low = B
        high = A
    }
    for (i in 1..low) {
        if (high * i % low == 0) return high * i
    }
    return A * B
}