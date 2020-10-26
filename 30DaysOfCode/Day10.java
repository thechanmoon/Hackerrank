import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day10 {

    static void printNumberOfOne(String str) {
        int result = 0;
        int sum = 0;
        boolean bCount = false;
        char[] chars = str.toCharArray();
        if (chars != null || chars.length > 0) {

            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '1')
                    bCount = true;
                else {
                    sum = 0;
                    bCount = false;
                }
                if (bCount == true) {
                    sum++;
                    if (sum > result) {
                        result = sum;
                    }
                }
                System.out.println("i = " + i);
                System.out.println("sum = " + sum);
                System.out.println("result = " + result);
                System.out.println("bCount = " + bCount);

            }
        }

        System.out.println(result);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        System.out.println(Integer.toString(n, 2));
        printNumberOfOne(Integer.toString(n, 2));

        scanner.close();
    }
}
