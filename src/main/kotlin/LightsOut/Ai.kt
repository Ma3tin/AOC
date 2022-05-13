package LightsOut

import fractions.getReciprocal

class Ai : Player {
   private val LastLines = arrayOf(
        arrayOf(false, false, false, true, true),
        arrayOf(false, false, true, false, false),
        arrayOf(false, true, false, false, true),
        arrayOf(false, true, true, true, false),
        arrayOf(true, false, false, true, false),
        arrayOf(true, false, true, false, true),
        arrayOf(true, true, false, false, false)
    )

    private val firstLines = arrayOf(
        arrayOf(true, false, true, true, true),
        arrayOf(true, true, false, true, true),
        arrayOf(true, true, true, true, false),
        arrayOf(false, false, true, true, true),
        arrayOf(false, true, true, true, true),
        arrayOf(false, true, true, false, true),
        arrayOf(true, true, true, false, true),
    )

    override fun nextMove(board: Board): Coordinates {
        for (x in 0..4) {
            for (y in 0..4) {
                if (x != 4) {
                    println("Coords $x $y")
                    for (row in board.asArray) {
                        for (square in row) {
                            if (square) print("◼️")
                            else print("◻️")
                        }
                        println()
                    }
                    if (board.asArray[x][y]) return Coordinates(x + 1, y)
                } else {
                    board.asArray[x] = checkLastLine(board.asArray[x])
                }
            }
        }

        return Coordinates(0, 0)
    }

    private fun checkLastLine(array: Array<Boolean>): Array<Boolean> {
        for (i in 0..6) {
            if (LastLines[i].contentEquals((array))) return firstLines[i]
        }
        return arrayOf(false, false, false, false, false)
    }


}