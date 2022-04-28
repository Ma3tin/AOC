package TicTacToe

class Human: Player{
    override fun getNextCoordinate(board: Board): Coordinate {
        println(board.grid[0][1])
        val x = readLine()
        val y = readLine()
        val coord = Coordinate(x!!.toInt(), y!!.toInt())
        return coord
    }
}