package com.example;

public class QuadraticEquation {
    public static double[] solve(double a, double b, double c) {
        if (a == 0) {
            throw new IllegalArgumentException("a must not be zero");
        }

        double delta = b * b - 4 * a * c;

        if (delta < 0) {
            return null; // Pas de racines réelles
        } else if (delta == 0) {
            return new double[]{ -b / (2 * a) }; // Une racine double
        } else {
            double sqrtDelta = Math.sqrt(delta);
            return new double[]{
                (-b + sqrtDelta) / (2 * a),
                (-b - sqrtDelta) / (2 * a)
            };
        }
    }
}
