import java.util.*

class HashTable<T> {
    val arrayOfList: Array<LinkedList<T>> = Array(2) { LinkedList() }

    fun add(number: T): Boolean {
        if (arrayOfList[number.hashCode() % arrayOfList.size].contains(number)) {
            arrayOfList[number.hashCode() % arrayOfList.size].add(number)
            return true
        }
        else return false
    }

    fun has(number: T): Boolean {
        return arrayOfList[number.hashCode() % arrayOfList.size].contains(number)
    }

}

fun main() {
    var table: HashTable = HashTable()
    table.add(7)
    table.add(8)
    table.add(9)
    table.add(10)
    println(table.has(9))
}

