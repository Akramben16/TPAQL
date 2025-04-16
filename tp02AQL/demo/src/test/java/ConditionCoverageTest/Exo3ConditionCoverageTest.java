package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.BinarySearch;

public class Exo3ConditionCoverageTest {
    @Test
    public void testEmptyArray() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{}, 1));
    }

    @Test
    public void testNullArray() {
        assertThrows(NullPointerException.class, () -> BinarySearch.binarySearch(null, 5));
    }
}
