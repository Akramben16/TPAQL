import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.example.Person;

class PersonTest {
    private Person adultPerson;
    private Person minorPerson;

    @BeforeEach
    void setUp() {
        adultPerson = new Person("Alice", "Dupont", 25);
        minorPerson = new Person("Bob", "Petit", 17);
    }

    @Test
    void getFullNameShouldReturnCorrectFormat() {
        assertEquals("Alice Dupont", adultPerson.getFullName());
    }

    @Test
    void isAdultShouldReturnTrueForAdults() {
        assertTrue(adultPerson.isAdult());
    }

    @Test
    void isAdultShouldReturnFalseForMinors() {
        assertFalse(minorPerson.isAdult());
    }
}
