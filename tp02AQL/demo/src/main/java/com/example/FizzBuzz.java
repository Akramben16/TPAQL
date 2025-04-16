package com.example;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be > 0");
        }

        if (number % 3 == 0 && number % 5 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(number);
        }
    }
}
