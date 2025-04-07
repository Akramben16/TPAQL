import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Calculator;

public class CalculatorTest {

    @Test
    @DisplayName("Add two numbers")
    void add() {
        assertEquals(4, Calculator.add(2, 2));
    }

    @Test
    @DisplayName("Multiply numbers")
    void multiply() {
        assertAll(
            () -> assertEquals(4, Calculator.multiply(2, 2)),
            () -> assertEquals(-4, Calculator.multiply(2, -2)),
            () -> assertEquals(4, Calculator.multiply(-2, -2)),
            () -> assertEquals(0, Calculator.multiply(1, 0))
        );
    }
}
