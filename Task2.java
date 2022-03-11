package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Task2.java - The program finds the given set of numbers that have exactly two different divisors
 * other than 1 and themselves.
 */
public class Task2 {

    private final static int[] FIRST_LINE = {4};
    private final static int[] SECOND_LINE = {6, 15, 9, 19};

    public static void main(String[] args) {
        try {
            System.out.println(getNumbersWithTwoDifferentDivisors(SECOND_LINE, FIRST_LINE[0]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error: Please check the entered lines. " + ex.getMessage());
        }
    }

    /**
     * Returns the set of numbers that have exactly two different divisors other than 1 and themselves.
     *
     * @param arr Set of numbers
     * @param m   Number of values in the set of numbers
     * @return Set of numbers that have exactly two different divisors other than 1 and themselves
     */
    private static ArrayList getNumbersWithTwoDifferentDivisors(int[] arr, int m) {
        ArrayList<Integer> result = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            if (hasTwoDifferentDivisors(arr[i])) {
                result.add(arr[i]);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    /**
     * Check and return the result if number have exactly two different divisors other than 1 and themselves.
     *
     * @param n Number to check
     * @return The result of the check as a boolean
     */
    private static boolean hasTwoDifferentDivisors(int n) {
        int divisors = 0;
        int j = n / 2;
        for (int i = 2; i <= j; i++) {
            if (n % i == 0) {
                divisors++;
            }
        }
        if (divisors == 2) {
            return true;
        }
        return false;
    }

}