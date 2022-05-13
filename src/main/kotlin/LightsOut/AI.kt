package LightsOut

class AI : Player {
    /**
     * Jak bude vypadat poslední řaděk po pozasínaní všech horních řádků
     */
   private val lastLines = arrayOf(
        arrayOf(false, false, false, true, true),
        arrayOf(false, false, true, false, false),
        arrayOf(false, true, false, false, true),
        arrayOf(false, true, true, true, false),
        arrayOf(true, false, false, true, false),
        arrayOf(true, false, true, false, true),
        arrayOf(true, true, false, false, false)
    )

    /**
     * Podle posledního řádku se nastaví prvni na jeden z těchto řádků
     */
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
        /**
         * Projedu pole na první řádky a nastavím všude hodnoty na true
         */
        for (y in 0 until board.asArray.lastIndex) {
            for (x in 0 until board.asArray.lastIndex) {

                println("Coords $x $y")
                if (board.asArray[x][y]) return Coordinates(y + 1, x)
                /**
                 * Když dojedu na konec tak nastavím podle posledního řaádku ten první
                 */
                    board.asArray[y] = checkLastLine(board.asArray[y])
            }
        }

        return Coordinates(0, 0)
    }

    /**
     * Podle posledního řádku se srvoná s tím jak by měli vypadat a podle toho nastaví první řádek
     */
    private fun checkLastLine(array: Array<Boolean>): Array<Boolean> {
        for (i in 0..6) {
            if (lastLines[i].contentEquals((array))) return firstLines[i]
        }
        return arrayOf(false, false, false, false, false)
    }


}