package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Palindrome;

public class Exo1BranchCoverageTest {
    @Test
    public void testPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }

    @Test
    public void testNullString() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
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
    public void testPalindromeLowercase() {
        assertTrue(Palindrome.isPalindrome("madam"));
    }

    @Test
    public void testNonPalindromeLowercase() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    public void testPalindromeMixedCase() {
        assertTrue(Palindrome.isPalindrome("Racecar"));
    }

    @Test
    public void testNonPalindromeMixedCase() {
        assertFalse(Palindrome.isPalindrome("RacecarX"));
    }

    @Test
    public void testPalindromeWithPunctuation() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testNonPalindromeWithPunctuation() {
        assertFalse(Palindrome.isPalindrome("A man, a plan, a canal: Panam"));
    }
}
