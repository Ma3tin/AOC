package LightsOut

class Board(private val array: Array<Array<Boolean>>) {

    val asArray: Array<Array<Boolean>>
        get() {
            return copyArray()
        }

    private fun copyArray(): Array<Array<Boolean>> {
        return Array(array.size) { array[it].copyOf() }
    }

    fun hasWon(): Boolean {
        for (booleans in array) {
            for (boolean in booleans) {
                if (boolean) return false
            }
        }
        return true
    }

    fun canPlay(coords: Coordinates): Boolean {
        return (coords.x in 0..4 && coords.y in 0..4)
    }

    fun play(coords: Coordinates): Board {
        val newArray = copyArray()
        if (canPlay(coords)) newArray[coords.y][coords.x] = !newArray[coords.y][coords.x]
        if (canPlay(Coordinates(coords.x, coords.y - 1))) newArray[coords.y - 1][coords.x] =
            !newArray[coords.y - 1][coords.x]
        if (canPlay(Coordinates(coords.x, coords.y + 1))) newArray[coords.y + 1][coords.x] =
            !newArray[coords.y + 1][coords.x]
        if (canPlay(Coordinates(coords.x + 1, coords.y))) newArray[coords.y][coords.x + 1] =
            !newArray[coords.y][coords.x + 1]
        if (canPlay(Coordinates(coords.x - 1, coords.y))) newArray[coords.y][coords.x - 1] =
            !newArray[coords.y][coords.x - 1]

        return Board(newArray)
    }
}