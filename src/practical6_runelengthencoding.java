import java.util.*;
import java.lang.*;

/**
 * Ronan O'Brien
 * 20404302
 * Practical 6
 */

public class practical6_runelengthencoding {

    public static void printRLE(final String input){
        int count = 1;
        String output = "";
        for (int i = 0; i < input.length(); i++){
            count = 1; //reset for each char
            while(i < input.length() - 1 && input.charAt(i) == input.charAt(i+1)){
                count++;
                i++;
            }
            output = output + input.charAt(i) + count;
        }
        System.out.println("Input = " + input);
        System.out.println("Output after compression = " + output);
    }

    public static void main(String[] aargs){
        printRLE("aaabbccccd");
    }
}
