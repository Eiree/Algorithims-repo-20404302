/**
 * Dynamic programming assignment 
 * COMP20290 Algorithims
 * Ronan O'Brien 20404302
 * 22/04/22
 */


//import java.lang.*;
//import java.util.*;

public class dynamicProgramming{

    /** 
     * rfib(n)
     * Recursive implementation of the fibnonnaci sequence.
     * Time complexity: O(2^n)
     * Auxiliary space complexity: O(n)
     * - n being input of given input
     * 
     * @param n size of given sequence
     * 
     */

    public static int rfib(final int n){
        if (n < 2){
            return n;
        }
        return rfib(n-1) + rfib(n-2);
    }

    /** 
     * dfib(n)
     * Dynamic implementation of the fibnonnaci sequence.
     * Time complexity: O(n)
     * Auxiliary space complexity: O(n)
     * - n being the length of given input
     * 
     * @param n size of given sequence.
     * 
     */

    public static int dfib(final int n){
        int[] cache = new int[n+1];
        cache[0] = 0;
        cache[1] = 1;
        for (int i = 2; i <= n; i++){
            cache[i] = cache[i-1] + cache[i+2];
        }
        return cache[n];
    }

    ///////////////////////////////////////////////

    /**
     * LCS(sOne, sTwo)
     * Dyamic implementation for longest common substring.
     * Time complexity: O(x*y)
     * Auxiliary space complexity: O(y)
     * - x and y are the lengths of respecitve first and second string inputs
     * 
     * @param sOne First input string
     * @param sTwo Second input string
     */

    public static int LCS(final String sOne, final String sTwo){ //bottom up, O(m*n) time || aux space O(n)
        int x, y, max, end;
        x = sOne.length();
        y = sTwo.length();
        int[][] lengths = new int[x+1][y+1];
        max = 0;
        end = 0;

        for (int i = 0; i < x; i++){
            for (int j = 0; j < y; j++){
                if (i == 0 || j == 0){
                    lengths[i][j] = 0;
                } else if (sOne.charAt(i-1) == sTwo.charAt(j-1)){
                    lengths[i][j] = lengths[i-1][j-1] + 1;
                    max = Math.max(max, lengths[i][j]);
                    end = i;
                } else {
                    lengths[i][j] = 0;
                }
            }
        }
        return Integer.parseInt(sOne.substring(end - max + 1, end + 1));
    }

    ///////////////////////////////////////////////

    /**
     * bknapsack(W, w, vals, n)
     * Brute-force implementation of the knapsack problem.
     * Time complexity: O(2^n)
     * Auxiliary space complexity: O(1)
     * - n being the number of weight elements
     * 
     * @param W capacity value
     * @param w Integer array for storing weight
     * @param vals Integer array for storing values
     * @param n Number of values
     */

    public static int bknapsack(final int W, final int[] w, final int[] vals, final int n){
        if (n == 0 || W == 0){
            return 0;
        }
        if (w[n-1] > W){
            return bknapsack(W, w, vals, n-1); //search
        } else {
            int value1 = bknapsack(W-w[n-1], w, vals, n-1);
            int value2 = bknapsack(W, w, vals, n-1);
            return Math.max(vals[n-1] + value1, value2);
        }
    }

    /**
     * dknapsack(W, w, vals)
     * Dynamic implementation of the knapsack problem.
     * Time complexity: O(n*W)
     * Auxiliary space complexity: O(n*W)
     * - n is the number of weight elements 
     * - W is capacity
     * 
     * @param W capacity value
     * @param w Integer array for storing weight
     * @param vals Integer array for storing values
     */

    public static int dknapsack(final int W, final int[] w, final int[] vals){
        int n = vals.length;
        if (n == 0 || W == 0){
            return 0;
        }
        int[][] cache= new int[n+1][W+1];
        for (int i = 0; i <= n; i++){
            for (int j = 0; j <= W; j++){
                if (i == 0 || j == 0){
                    cache[i][j] = 0;
                } else if (w[i-1] > j){
                    cache[i][j] = cache[i-1][j];
                } else {
                    cache[i][j] = Math.max(cache[i-1][j], cache[i-1][j-w[i-1]] + vals[i-1]);
                }
            }
        }
        return cache[n][W];
    }
}