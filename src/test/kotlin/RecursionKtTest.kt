import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

internal class RecursionKtTest {

    @Test
    fun childAdd() {
        assertEquals(8, childAdd(5, 3))
        assertEquals(19, childAdd(10, 9))
    }

    @Test
    fun childProduct() {
        assertEquals(15, childProduct(5, 3))
        assertEquals(25, childProduct(5, 5))
    }

    @Test
    fun product() {
        assertEquals(125, product(5, 3))
        assertEquals(64, product(2, 6))
    }

    @Test
    fun count() {
        assertEquals(10, count("253"))
        assertEquals(15, count("69"))
    }

    @Test
    fun isPalindrome() {
        assertEquals(true, isPalindrome("rotor"))
        assertEquals(true, isPalindrome("anna"))
        assertNotEquals(true, isPalindrome("martin"))
    }
}