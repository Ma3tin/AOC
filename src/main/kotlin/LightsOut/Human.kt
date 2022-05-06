package LightsOut

class Human : Player {
    override fun nextMove(board: Board): Coordinates {
        for (row in board.asArray) {
            for (square in row) {
                if (square) print("◼️")
                else print("◻️")
            }
            println()
        }

        println("Zadej x")
        var x = readLine()!!.toInt()

        println("Zadej y")
        var y = readLine()!!.toInt()

        var coords = Coordinates(x, y)
        while (!board.canPlay(coords)) {
            println("Nevalidní souřadninec, zadej je znova")

            println("Zadej x")
            x = readLine()!!.toInt()

            println("Zadej y")
            y = readLine()!!.toInt()
            coords = Coordinates(x, y)
        }
        return coords
    }
}