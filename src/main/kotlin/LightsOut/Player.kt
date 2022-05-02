package LightsOut

interface Player {
    fun nextMove(board: Board): Coordinates
    /*
    Vypise board
    nacte coords
    check zda coord jsou v poli
     */
}