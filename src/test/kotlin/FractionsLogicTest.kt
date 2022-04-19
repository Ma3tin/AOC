import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


internal class FractionsLogicTest {
    @Test
    fun  findGreatestCommonDenominator()  {
        assertEquals(4, fractions.findGreatestCommonDenominator(8, 12))
        assertEquals(5, fractions.findGreatestCommonDenominator(10, 5))
        assertEquals(5, fractions.findGreatestCommonDenominator(20, 5))
        assertEquals(1, fractions.findGreatestCommonDenominator(21, 5))
    }


    @Test
    fun findLowestCommonMultiple() {
        assertEquals(60, fractions.findLowestCommonMultiple(12, 15))
        assertEquals(4, fractions.findLowestCommonMultiple(2, 4))
        assertEquals(50, fractions.findLowestCommonMultiple(10, 25))

    }
}