package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.QuadraticEquation;
import java.util.Arrays;

public class Exo4BranchCoverageTest {
    @Test
    public void testTwoRealRoots() {
        double[] expected = {-2.0, -1.0};
        double[] result = QuadraticEquation.solve(1, 3, 2);
        Arrays.sort(result);
        assertArrayEquals(expected, result, 0.0001);
    }

    @Test
    public void testAIsZero() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticEquation.solve(0, 2, 1));
    }
}
