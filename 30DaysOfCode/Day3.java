import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day3 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        scanner.close();

        // If is odd, print Weird
        // If is even and in the inclusive range of 2 to 5, print Not Weird
        // If is even and in the inclusive range of 6 to 20, print Weird
        // If is even and greater than 20, print Not Weird

        if (N % 2 == 1) {
            System.out.println("Weird");
        } else if (N > 1 && N < 6) {
            System.out.println("Not Weird");
        } else if (N > 5 && N < 21) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }
}
