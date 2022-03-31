import java.util.*
import kotlin.collections.Iterator

class HashTable<T> {
    val arrayOfList: Array<LinkedList<T>> = Array(2) { LinkedList() }

    fun add(number: T): Boolean {
        if (arrayOfList[number.hashCode() % arrayOfList.size].contains(number)) {
            arrayOfList[number.hashCode() % arrayOfList.size].add(number)
            return true
        }
        else return false
    }

    fun has(number: T): Boolean = arrayOfList[number.hashCode() % arrayOfList.size].contains(number)


    fun delete(value: T): Boolean = arrayOfList[value.hashCode() % arrayOfList.size].remove(value)

    fun size(): Int = arrayOfList.sumOf { it.size }

    fun iterator(): Iterator<T> = arrayOfList.asSequence().flatten().iterator()

}

fun main() {
    val table: HashTable<Int> = HashTable()
    table.add(7)
    table.add(8)
    table.add(9)
    table.add(10)
    println(table.has(9))
}

