package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Anagram;

public class Exo2BranchCoverageTest {
    @Test
    public void testValidAnagram() {
        assertTrue(Anagram.isAnagram("listen", "silent"));
    }

    @Test
    public void testInvalidAnagram() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    @Test
    public void testNullStrings() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "test"));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("test", null));
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    @Test
    public void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    public void testDifferentLengths() {
        assertFalse(Anagram.isAnagram("short", "longer"));
    }

    @Test
    public void testSameString() {
        assertTrue(Anagram.isAnagram("test", "test"));
    }

    @Test
    public void testAnagramWithSpaces() {
        assertTrue(Anagram.isAnagram("debit card", "bad credit"));
    }

    @Test
    public void testAnagramWithDifferentCase() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    public void testAnagramWithSpecialCharacters() {
        assertTrue(Anagram.isAnagram("dormitory", "dirty room"));
    }
}
