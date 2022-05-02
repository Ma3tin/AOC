package LightsOut

class Game {
    private var board: Board = Board()
    private var player: Player = Human()

    fun runGame(): Int {
        var countOfMoves = 0
        while (!board.hasWon()) {
            board = board.play(player.nextMove(board))
            countOfMoves++
            if (board.hasWon()) {
                println("Vyhrál jste!! a stačilo vám k tomu $countOfMoves")
                return countOfMoves
            }
        }
        return -1
    }
}