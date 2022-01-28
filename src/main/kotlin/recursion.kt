tailrec fun childAdd(number1: Int, number2: Int): Int {
    if (number2 <= 0) return number1
    return childAdd(number1 + 1, number2 - 1)
}

tailrec fun childProduct(number1: Int, number2: Int, result: Int = 0): Int {
    if (number2 <= 0) return result
    return childProduct(number1, number2 - 1, result + number1)
}

tailrec fun product(number1: Int, number2: Int, result: Int = 1): Int {
    if (number2 <= 0) return result
    return product(number1, number2 - 1, result * number1)
}

tailrec fun count(number: String, result: Int = 0): Int {
    if (number.isEmpty()) return result
    return count(number.substring(1), result + number[0].digitToInt())
}

tailrec fun isPalindrome(input: String): Boolean {
    if (input.length <= 1) return true
    else if (input[0] == input[input.length - 1]) return isPalindrome(input.substring(1, input.length - 1))
    else return false
}


fun main() {
    println(childAdd(10, 8))
    println(childProduct(5, 3))
    println(product(5, 3))
    println(count("235"))
    println(isPalindrome("rotor"))
}