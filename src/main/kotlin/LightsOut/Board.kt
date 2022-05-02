package LightsOut

class Board {
    var array = Array(5) { Array(5) {true} }


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
        val newArray = array.copyOf()
        if (canPlay(coords)) newArray[coords.y][coords.x] = !newArray[coords.y][coords.x]
        if (canPlay(Coordinates(coords.x, coords.y - 1))) newArray[coords.y - 1][coords.x] = !newArray[coords.y - 1][coords.x]
        if (canPlay(Coordinates(coords.x, coords.y + 1))) newArray[coords.y + 1][coords.x] = !newArray[coords.y + 1][coords.x]
        if (canPlay(Coordinates(coords.x + 1, coords.y))) newArray[coords.y][coords.x + 1] = !newArray[coords.y][coords.x + 1]
        if (canPlay(Coordinates(coords.x - 1, coords.y))) newArray[coords.y][coords.x - 1] = !newArray[coords.y][coords.x - 1]

        val board = Board()
        board.array = newArray
        return board
    }
}