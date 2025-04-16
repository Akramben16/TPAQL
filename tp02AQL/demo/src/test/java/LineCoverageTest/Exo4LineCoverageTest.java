package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.example.QuadraticEquation;

public class Exo4LineCoverageTest {
    @Test
    public void testDoubleRoot() {
        assertArrayEquals(new double[]{-1.0}, QuadraticEquation.solve(1, 2, 1), 0.0001);
    }

    @Test
    public void testNoRealRoot() {
        assertNull(QuadraticEquation.solve(1, 0, 1));
    }
}
