package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.BinarySearch;

public class Exo3BranchCoverageTest {
    @Test
    public void testFirstElement() {
        assertEquals(0, BinarySearch.binarySearch(new int[]{2, 4, 6, 8}, 2));
    }

    @Test
    public void testLastElement() {
        assertEquals(3, BinarySearch.binarySearch(new int[]{2, 4, 6, 8}, 8));
    }
}
