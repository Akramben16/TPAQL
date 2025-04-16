package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @Test
    void testFizzBuzz_DivisibleBy3() {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(3));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(6));
        assertEquals("Fizz", FizzBuzz.fizzBuzz(9));
    }

    @Test
    void testFizzBuzz_DivisibleBy5() {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(5));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(10));
        assertEquals("Buzz", FizzBuzz.fizzBuzz(20));
    }

    @Test
    void testFizzBuzz_DivisibleBy3And5() {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(15));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(30));
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(45));
    }

    @Test
    void testFizzBuzz_NotDivisibleBy3Or5() {
        assertEquals("1", FizzBuzz.fizzBuzz(1));
        assertEquals("2", FizzBuzz.fizzBuzz(2));
        assertEquals("7", FizzBuzz.fizzBuzz(7));
    }

    @Test
    void testFizzBuzz_InvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(0));
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(-5));
    }
}
