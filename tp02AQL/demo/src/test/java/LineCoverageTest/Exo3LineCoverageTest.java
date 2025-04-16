package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.BinarySearch;

public class Exo3LineCoverageTest {
    @Test
    public void testFound() {
        assertEquals(2, BinarySearch.binarySearch(new int[]{1, 3, 5, 7}, 5));
    }

    @Test
    public void testNotFound() {
        assertEquals(-1, BinarySearch.binarySearch(new int[]{1, 3, 5, 7}, 4));
    }
}
