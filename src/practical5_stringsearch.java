import java.util.*;
import java.lang.*;

/**
 * Ronan O'Brien
 * 20404302
 * Practical 5
 */
public class practical5_stringsearch {
    //Brute Force
    public static int stringSearch(String pat, String string){
        int N = string.length();
        int M = pat.length();
        for (int i = 0; i <= N - M; i++){
            for (int j = 0; j < M; j++){
                if (string.charAt(i+j) != pat.charAt(j)){ //continue
                    break;
                }
                if (j == M){
                    System.out.println("Pattern found at index " + (i - j));
                    return i; //return index
                }
            }
        }
        return N; //not found
    }


    //Knuth-Morris-Prath
    public static int KMPsearch(String pat, String txt){
        int M = pat.length();
        int N = txt.length();

        if (N == 0){
            return 0;
        }

        int lps[] = new int[M];
        int j = 0; //index for pattern

        computeLPSArray(pat, M, lps); //pattern pre-process

        int i = 0;
        while (i < N){
            if (pat.charAt(j) == txt.charAt(i)){
                i++;
                j++;
            }
            if (j == M){ //found string pattern
                System.out.println("Pattern found at index " + (i - j));
                return i - j;
            } else if (i < N && pat.charAt(j) != txt.charAt(i)){ //mismatch j
                if (j != 0){
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    private static int[] computeLPSArray(final String pat, final int M, final int lps[]){
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M){
            if (pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0){
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args){
        String txt = "ABABDABACDABABCABBAB";
        String pat = "ABABCABAB";
        long timerStart = 0;
        long timerEnd = 0;
        long timerTotal = 0;
        System.out.println("KMP ~");
        timerStart = System.currentTimeMillis();
        KMPsearch(pat, txt);
        timerEnd = System.currentTimeMillis();
        timerTotal = timerEnd - timerStart;
        System.out.println("Total time = " + timerTotal + "\n");
        System.out.println("Bruteforce ~\n");
        timerStart = System.nanoTime();
        int index = stringSearch(pat, txt);
        System.out.println("Index of BFA: " + index);
        timerEnd = System.nanoTime();
        timerTotal = timerEnd - timerStart;
        System.out.println("Total time = " + timerTotal + "\n");
    }
}