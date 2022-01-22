import java.lang.IndexOutOfBoundsException

class IntArrayList {

    private var array: Array<Int?> = Array(0) {0}

    fun size(): Int {
        return this.array.size
    }

    fun isEmpty(): Boolean {
        return this.array.isEmpty()
    }

    fun indexOf(nbr: Int): Int {
        return this.array.indexOf(nbr)
    }

    fun toArray(): Array<Int?> {
        return this.array.copyOf()
    }

    fun get(index: Int): Int? {
        if (index <= this.array.size) return this.array[index]
        else throw IndexOutOfBoundsException()
    }

    fun add(nbr: Int) {
        val newArray = this.array.copyOf(this.array.size + 1)
        newArray[newArray.size-1] = nbr
        this.array = newArray
    }

    fun set(index: Int,nbr: Int){
        if (index < this.array.size) this.array[index] = nbr
        else throw IndexOutOfBoundsException()
    }

    fun contains(nbr: Int): Boolean {
        for (i in this.array.indices){
            if(this.array[i] == nbr ) return true
        }
        return false
    }

    fun lastIndexOf(nbr: Int): Int{
        for(i in this.array.size-1 downTo 0)
            if(this.array[i] == nbr){
                return i
            }
        return -1
    }

}