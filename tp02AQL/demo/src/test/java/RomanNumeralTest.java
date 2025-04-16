package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", numLinesToSkip = 1)
    void testToRoman_Parametrized(int input, String expectedOutput) {
        assertEquals(expectedOutput, RomanNumeral.toRoman(input));
    }

    @Test
    void testToRoman_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(0));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(4000));
        assertThrows(IllegalArgumentException.class, () -> RomanNumeral.toRoman(-1));
    }
}
