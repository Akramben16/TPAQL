import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Fibonacci;

class FibonacciTest {
    @BeforeEach
    void setUp() {
        // No initialization needed as Fibonacci methods are static
    }

    @Test
    void fibonacciShouldReturnCorrectValues() {
        assertEquals(0, Fibonacci.fibonacci(0));
        assertEquals(1, Fibonacci.fibonacci(1));
        assertEquals(5, Fibonacci.fibonacci(5));
    }

    @Test
    void fibonacciShouldThrowExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }
}
