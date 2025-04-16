package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Anagram;

public class Exo2ConditionCoverageTest {
    @Test
    public void testEmptyStrings() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    public void testNotAnagram() {
        assertFalse(Anagram.isAnagram("chat", "chien"));
    }

    @Test
    public void testAnagramsWithDifferentCases() {
        assertTrue(Anagram.isAnagram("Listen", "Silent"));
    }

    @Test
    public void testAnagramsWithSpaces() {
        assertTrue(Anagram.isAnagram("dormitory", "dirty room"));
    }

    @Test
    public void testAnagramsWithPunctuation() {
        assertTrue(Anagram.isAnagram("Conversation", "Voices rant on"));
    }

    @Test
    public void testLongAnagrams() {
        assertTrue(Anagram.isAnagram("parliament", "partial men"));
    }

    @Test
    public void testNotAnagramsWithSameLength() {
        assertFalse(Anagram.isAnagram("hello", "world"));
    }

    @Test
    public void testNotAnagramsWithSimilarCharacters() {
        assertFalse(Anagram.isAnagram("aabbc", "abcdd"));
    }

    @Test
    public void testSingleCharacterAnagrams() {
        assertTrue(Anagram.isAnagram("a", "a"));
    }

    @Test
    public void testSingleCharacterNotAnagrams() {
        assertFalse(Anagram.isAnagram("a", "b"));
    }
}
