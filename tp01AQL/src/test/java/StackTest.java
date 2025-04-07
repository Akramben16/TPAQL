import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Stack;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void pushShouldIncreaseSize() {
        stack.push(10);
        assertEquals(1, stack.size());
    }

    @Test
    void popShouldReturnLastPushedElement() {
        stack.push(5);
        stack.push(10);
        assertEquals(10, stack.pop());
    }

    @Test
    void popShouldThrowExceptionWhenStackIsEmpty() {
        assertThrows(IllegalStateException.class, stack::pop);
    }

    @Test
    void peekShouldReturnTopElementWithoutRemovingIt() {
        stack.push(20);
        assertEquals(20, stack.peek());
        assertEquals(1, stack.size());
    }

    @Test
    void isEmptyShouldReturnTrueForNewStack() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void isEmptyShouldReturnFalseAfterPush() {
        stack.push(30);
        assertFalse(stack.isEmpty());
    }
}
