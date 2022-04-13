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

}

