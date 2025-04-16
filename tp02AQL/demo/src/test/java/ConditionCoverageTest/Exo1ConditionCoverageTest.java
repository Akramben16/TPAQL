package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Palindrome;

public class Exo1ConditionCoverageTest {
    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void testValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("madam"));
    }

    @Test
    public void testValidPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("race car"));
    }

    @Test
    public void testMixedCasePalindrome() {
        assertTrue(Palindrome.isPalindrome("Racecar"));
    }

    @Test
    public void testInvalidPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testLongValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testPalindromeWithNumbers() {
        assertTrue(Palindrome.isPalindrome("12321"));
    }

    @Test
    public void testInvalidPalindromeWithNumbers() {
        assertFalse(Palindrome.isPalindrome("12345"));
    }
}