package org.example;

public class Main {
    public static void main(String[] args) {
        // Test the calculator
        double sum = Calculator.add(1.0, 2.0, 3.0);
        double product = Calculator.multiply(2.0, 3.0, 4.0);
        
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
} 