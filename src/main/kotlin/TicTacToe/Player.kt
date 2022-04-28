package TicTacToe

interface Player {
    data class Player(var symbol: Char)
    fun getNextCoordinate(grid: Board): Coordinate
}