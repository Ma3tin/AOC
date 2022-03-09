import kotlin.math.sqrt

fun isPrime(number: Int): Boolean {
    for (i in 2..(sqrt(number.toDouble()).toInt())) {
        if (number % i == 0) return false

    }
    return true
}

class PrimeIterator(private val limit: Int) : Iterator<Int> {
    private var number = 1
    override fun hasNext(): Boolean {
        return number <= limit
    }

    override fun next(): Int {
        number = closestPrime(++number)
        return number
    }

}

fun closestPrime(number: Int): Int {
    if (isPrime(number)) return number
    val nextStep = number + 1
    return closestPrime(nextStep)
}


fun main() {
    val prime = Iterable { PrimeIterator(100) }
    for (v in prime)
        println(v)

}