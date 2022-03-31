import java.util.*
import kotlin.collections.Iterator

class HashTable<T> {
    private val arrOfLinkedLists: Array<LinkedList<T>> = Array(2) { LinkedList() }

    fun add(number: T): Boolean {
        if (arrOfLinkedLists[number.hashCode() % arrOfLinkedLists.size].contains(number)) {
            arrOfLinkedLists[number.hashCode() % arrOfLinkedLists.size].add(number)
            return true
        } else return false
    }

    fun has(number: T): Boolean = arrOfLinkedLists[number.hashCode() % arrOfLinkedLists.size].contains(number)


    fun delete(value: T): Boolean = arrOfLinkedLists[value.hashCode() % arrOfLinkedLists.size].remove(value)

    fun size(): Int = arrOfLinkedLists.sumOf { it.size }

    fun iterator(): Iterator<T> = arrOfLinkedLists.asSequence().flatten().iterator()

}

fun main() {
    val table: HashTable<Int> = HashTable()
    table.add(7)
    table.add(8)
    table.add(9)
    table.add(10)
    println(table.has(9))
}

