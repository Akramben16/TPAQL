package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.Anagram;

public class Exo2LineCoverageTest {
    @Test
    public void testValidAnagram() {
        assertTrue(Anagram.isAnagram("chien", "niche"));
    }

    @Test
    public void testDifferentLength() {
        assertFalse(Anagram.isAnagram("chat", "chats"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(Anagram.isAnagram("", ""));
    }

    @Test
    public void testNullString1() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, "abc"));
    }

    @Test
    public void testNullString2() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram("abc", null));
    }

    @Test
    public void testNullStrings() {
        assertThrows(NullPointerException.class, () -> Anagram.isAnagram(null, null));
    }

    @Test
    public void testCaseSensitive() {
        assertTrue(Anagram.isAnagram("Chien", "niche"));
    }

    @Test
    public void testWithSpaces() {
        assertTrue(Anagram.isAnagram("chien ", " niche"));
    }

    @Test
    public void testSpecialCharacters() {
        assertTrue(Anagram.isAnagram("!@#$", "$#@!"));
    }

    @Test
    public void testUnicodeCharacters() {
        assertTrue(Anagram.isAnagram("你好世界", "界世好你"));
    }
}
