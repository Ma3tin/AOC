package fractions

data class Fraction(var numerator: Int, var denominator: Int)


operator fun Fraction.plus(other: Fraction): Fraction {
    val smallestMultiple = findLowestCommonMultiple(this.denominator, other.denominator)
    val firstNumerator: Int = smallestMultiple / this.denominator
    val secondNumerator: Int = smallestMultiple / other.denominator
    val nominator: Int = firstNumerator * this.numerator + secondNumerator * other.numerator
    return simplify(Fraction(nominator, smallestMultiple))
}

operator fun Fraction.minus(other: Fraction):Fraction {
    val smallestMultiple: Int = findLowestCommonMultiple(this.denominator, other.denominator)
    val firstNumerator: Int = smallestMultiple / this.denominator
    val secondNumerator = smallestMultiple / other.denominator
    val nominator: Int = firstNumerator * this.numerator - secondNumerator * other.numerator
    return simplify(Fraction(nominator, smallestMultiple))
}

operator fun Fraction.times(other: Fraction):Fraction {
    val newNumerator: Int = this.numerator * other.numerator
    val newDenominator: Int = this.denominator * other.denominator
    return simplify(Fraction(newNumerator, newDenominator))

}

operator fun Fraction.div(other: Fraction): Fraction {
    return simplify(times(getReciprocal(other)))
}

fun getReciprocal(first: Fraction): Fraction {
    return Fraction(first.denominator, first.numerator)
}

fun simplify(first: Fraction): Fraction {
    val multiplier: Int = findGreatestCommonDenominator(first.numerator, first.denominator)
    return Fraction(first.numerator / multiplier, first.denominator / multiplier)
}

fun toFloat(first: Fraction): Float {
    return first.numerator.toFloat() / first.denominator.toFloat()
}
fun main() {
    println(Fraction(10,5) / Fraction(1, 2))
}
