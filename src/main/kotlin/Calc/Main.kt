package Calc


fun main() {
    val ops: Map<String, Operation> = mapOf("+" to Add(), "-" to Minus(), "/" to Div(), "*" to Mul())
    val input = readLine()
    val inputs = input!!.split(" ")
    val numberOne = inputs[0].toDouble()
    val operator = inputs[1]
    val numberTwo = inputs[2].toDouble()
    println(ops[operator]!!.calc(numberOne, numberTwo))
}