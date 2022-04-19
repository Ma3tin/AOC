package fractions

data class Fraction(var numerator: Int, var denominator: Int)


fun plus(first: Fraction, other: Fraction): Fraction {
    val smallestMultiple = findLowestCommonMultiple(first.denominator, other.denominator)
    val firstNumerator: Int = smallestMultiple / first.denominator
    val secondNumerator: Int = smallestMultiple / other.denominator
    val nominator: Int = firstNumerator * first.numerator + secondNumerator * other.numerator
    return simplify(Fraction(nominator, smallestMultiple))
}

fun minus(first: Fraction, other: Fraction): Fraction {
    val smallestMultiple: Int = findLowestCommonMultiple(first.denominator, other.denominator)
    val firstNumerator: Int = smallestMultiple / first.denominator
    val secondNumerator = smallestMultiple / other.denominator
    val nominator: Int = firstNumerator * first.numerator - secondNumerator * other.numerator
    return simplify(Fraction(nominator, smallestMultiple))
}

fun times(first: Fraction, other: Fraction): Fraction {
    val newNumerator: Int = first.numerator * other.numerator
    val newDenominator: Int = first.denominator * other.denominator
    return simplify(Fraction(newNumerator, newDenominator))
}

fun dividedBy(first: Fraction, other: Fraction): Fraction {
    return simplify(times(first, getReciprocal(other)))
}

fun getReciprocal(first: Fraction): Fraction {
    return Fraction(first.denominator, first.numerator)
}

fun simplify(first: Fraction): Fraction {
    val multiplier: Int = findGreatestCommonDenominator(first.numerator, first.denominator)
    return Fraction(first.numerator / multiplier, first.denominator / multiplier)
}

fun toFloat(first: Fraction): Float {
    return first.numerator as Float / first.denominator
}