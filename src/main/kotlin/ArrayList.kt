import java.lang.IndexOutOfBoundsException

class ArrayList {
    private var array: Array<Any?> = arrayOfNulls(0)

    fun size(): Int {
        return this.array.size
    }

    fun isEmpty(): Boolean {
        return this.array.isEmpty()
    }

    fun<T> indexOf(value: T): Int {
        return this.array.indexOf(value)
    }

    fun toArray(): Array<Any?> {
        return this.array.clone()
    }

    fun get(index: Int): Any? {
        if (index <= this.array.size) return this.array[index]
        else throw IndexOutOfBoundsException()
    }

    fun<T> add(nbr: T) {
        val newArray = this.array.copyOf(this.array.size + 1)
        newArray[newArray.size-1] = nbr
        this.array = newArray
    }

    fun<T> set(index: Int,nbr: T){
        if (index < this.array.size) this.array[index] = nbr
        else throw IndexOutOfBoundsException()
    }

    fun<T> contains(nbr: T): Boolean {
        for (i in this.array.indices){
            if(this.array[i] == nbr ) return true
        }
        return false
    }

    fun<T> lastIndexOf(nbr: T): Int{
        for(i in this.array.size-1 downTo 0)
            if(this.array[i] == nbr){
                return i
            }
        return -1
    }
}