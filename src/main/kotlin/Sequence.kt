fun isPrimeSequence() = sequence {
    val max = Int.MAX_VALUE
    for (v in 1..max) {
        if (isPrime(v)) yield(v)
    }
}

fun main() {
    for(v in isPrimeSequence().take(100)){
        println(v)
    }

    for(v in isPrimeSequence().takeWhile { it < 100 }) {
        println(v)
    }
}