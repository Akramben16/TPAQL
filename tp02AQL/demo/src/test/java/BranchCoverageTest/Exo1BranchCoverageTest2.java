package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Palindrome;

public class Exo1BranchCoverageTest2 {
    @Test
    public void testPalindromeWithSpecialCharacters() {
        assertTrue(Palindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void testPalindromeWithNumbers() {
        assertTrue(Palindrome.isPalindrome("12321"));
    }

    @Test
    public void testNonPalindromeWithNumbers() {
        assertFalse(Palindrome.isPalindrome("12345"));
    }

    @Test
    public void testPalindromeWithMixedCharacters() {
        assertTrue(Palindrome.isPalindrome("A1B2B1A"));
    }

    @Test
    public void testNonPalindromeWithMixedCharacters() {
        assertFalse(Palindrome.isPalindrome("A1B2C3D"));
    }
} 