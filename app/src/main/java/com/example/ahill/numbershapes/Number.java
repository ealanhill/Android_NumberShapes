package com.example.ahill.numbershapes;

/**
 * A simple number class to hold an int for checking to see if it is triangular or square.
 *
 * Created by ahill on 4/29/2016.
 */
public class Number {
    private int number;

    /**
     * Constructs a Number object with the given number.
     * @param number
     */
    public Number(int number) {
        this.number = number;
    }

    /**
     * Checks to see if a given number is triangular or not
     *
     * @return
     */
    public boolean isTriangular() {
        // a triangular number is found in the formula ( n (n + 1) ) / 2,
        // if we set the triangular number equal the above formula, we get:
        // 8T + 1 = (2n + 1)^2,
        // so a triangular number is one where 8T + 1 is odd and a perfect square
        int value = 8 * number + 1;

        // check for the value to be odd
        return value % 2 != 0 && new Number(value).isPerfectSquare();
    }

    /**
     * Checks to see if the given number is a perfect square.
     *
     * @return
     */
    public boolean isPerfectSquare() {
        // perform the square root of the number
        double squareRoot = Math.sqrt((double) number);

        // get any remainder after the decimal point in the square root value, and check to see
        // if it is equal to 0, a zero value indicates a perfect square
        return (squareRoot - Math.floor(squareRoot)) == 0;
    }

    public String toString() {
        return String.valueOf(number);
    }
}
