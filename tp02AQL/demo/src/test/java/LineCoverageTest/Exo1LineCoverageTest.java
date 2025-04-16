package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Palindrome;

public class Exo1LineCoverageTest {
    @Test
    public void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }

    @Test
    public void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("bonjour"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    public void testMixedCasePalindrome() {
        assertTrue(Palindrome.isPalindrome("Kayak"));
    }

    @Test
    public void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Was it a car or a cat I saw"));
    }

    @Test
    public void testPalindromeWithPunctuation() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
