import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Factorial;

class FactorialTest {
    @BeforeEach
    void setUp() {
        // No initialization needed as Factorial methods are static
    }

    @Test
    void factorialShouldReturnCorrectValues() {
        assertEquals(1, Factorial.factorial(0));
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void factorialShouldThrowExceptionForNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
}
