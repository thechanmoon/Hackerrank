import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day6 {

    static void printStrings(String[] strings) {
        for (int i = 0; i < strings.length; i++)
            printString(strings[i]);
    }

    static void printString(String str) {
        // String retString = str;
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                System.out.print(chars[i]);
            }
        }

        System.out.print(" ");

        for (int i = 0; i < chars.length; i++) {
            if (i % 2 != 0) {
                System.out.print(chars[i]);
            }
        }

        System.out.println("");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] strArray = new String[n];
        for (int i = 0; i < n; i++) {
            strArray[i] = scanner.nextLine();
        }
        printStrings(strArray);
        scanner.close();
    }
}