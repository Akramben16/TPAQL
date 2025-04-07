import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Prime;

class PrimeTest {

    @Test
    void isPrimeShouldReturnTrueForPrimes() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(13));
    }

    @Test
    void isPrimeShouldReturnFalseForNonPrimes() {
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(10));
        assertFalse(Prime.isPrime(20));
    }

    @Test
    void isPrimeShouldReturnFalseForNegativeNumbers() {
        assertFalse(Prime.isPrime(-5));
    }
}
