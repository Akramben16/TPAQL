package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.QuadraticEquation;
import java.util.Arrays;

public class Exo4ConditionCoverageTest {
    @Test
    public void testDeltaZero() {
        double[] result = QuadraticEquation.solve(4, 4, 1);
        assertArrayEquals(new double[]{-0.5}, result, 0.0001);
    }

    @Test
    public void testDeltaPositive() {
        double[] result = QuadraticEquation.solve(1, -3, 2);
        Arrays.sort(result);
        assertArrayEquals(new double[]{1.0, 2.0}, result, 0.0001);
    }
}
