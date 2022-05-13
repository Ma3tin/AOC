package LightsOut

class Game {
    private var board: Board = Board(Array(5){Array(5){false}})
    private var player: Player = AI()

    fun runGame(): Int {
        board = board.play(Coordinates(0, 0))
        var countOfMoves = 0
        while (!board.hasWon()) {
            board = board.play(player.nextMove(board))
            countOfMoves++
            if (board.hasWon()) println("Vyhrál jste!! a stačilo vám k tomu $countOfMoves")
        }
        return countOfMoves
    }
}