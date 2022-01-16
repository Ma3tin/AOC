class RainDeer(

    private val name: String,
    private val speed: Int = 0,
    private val rest: Int = 0,
    private val duration: Int = 0

) {
    override fun toString(): String {
        return "RainDeer(name='$name', speed=$speed, rest=$rest, duration=$duration)"
    }

    fun getDistance(): Int {
        var time = 2503
        var distance = 0
        while (time >= 0) {
            var duration: Int = this.duration
            while (duration != 0) {
                distance += this.speed
                duration--

            }
            time -= (this.rest + this.duration)
        }
        return distance
    }
}


fun main() {
    /*val input = "Comet can fly 14 km/s for 10 seconds, but then must rest for 127 seconds.\n" +
            "Dancer can fly 16 km/s for 11 seconds, but then must rest for 162 seconds."

    */
    val input = "Vixen can fly 19 km/s for 7 seconds, but then must rest for 124 seconds.\n" +
            "Rudolph can fly 3 km/s for 15 seconds, but then must rest for 28 seconds.\n" +
            "Donner can fly 19 km/s for 9 seconds, but then must rest for 164 seconds.\n" +
            "Blitzen can fly 19 km/s for 9 seconds, but then must rest for 158 seconds.\n" +
            "Comet can fly 13 km/s for 7 seconds, but then must rest for 82 seconds.\n" +
            "Cupid can fly 25 km/s for 6 seconds, but then must rest for 145 seconds.\n" +
            "Dasher can fly 14 km/s for 3 seconds, but then must rest for 38 seconds.\n" +
            "Dancer can fly 3 km/s for 16 seconds, but then must rest for 37 seconds.\n" +
            "Prancer can fly 25 km/s for 6 seconds, but then must rest for 143 seconds."
    val lines = input.split("\n")
    val raindeers = mutableListOf<RainDeer>()
    val first = mutableListOf<Int>()

    for (i in lines) {
        val words = i.split(" ")
        raindeers.add(RainDeer(words[0], words[3].toInt(), words[13].toInt(), words[6].toInt()))
        //println(raindeers.last())
        first.add(raindeers.last().getDistance())
    }
    first.sort()
    println(first.last())
}