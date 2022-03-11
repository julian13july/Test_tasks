package com.company;

import java.util.Arrays;

/**
 * Task1.java - The program finds the m-th largest value in the given set of numbers.
 */
public class Task1 {

    private final static int[] FIRST_LINE = {4, 3};
    private final static int[] SECOND_LINE = {1, 2, 3, 4};

    public static void main(String[] args) {
        try {
            System.out.println(getLargestNumber(SECOND_LINE, FIRST_LINE[0], FIRST_LINE[1]));
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Error: Please check the entered lines. " + ex.getMessage());
        }
    }

    /**
     * Returns the m-th largest value in the given set of numbers.
     *
     * @param arr Set of numbers
     * @param n   Number of values in the set of numbers
     * @param m   Parameter of which m-th greatest value is of interest to us
     * @return The m-th largest value
     */
    private static int getLargestNumber(int[] arr, int n, int m) {
        Arrays.sort(arr);
        return arr[n - m];
    }

}