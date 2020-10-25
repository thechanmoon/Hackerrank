import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.lang.model.util.ElementScanner14;

public class Day26 {
    public static int printFine(int[][] arr) {
        int fine = 0;
        int diffYear = arr[0][2] - arr[1][2];
        int diffMonth = arr[0][1] - arr[1][1];
        int diffDay = arr[0][0] - arr[1][0];

        // System.out.println(diffYear);
        // System.out.println(diffMonth);
        // System.out.println(diffDay);

        if (diffYear > 0) {
            fine = 10000;
        } else if (diffYear == 0) {
            if (diffMonth > 0) {
                fine = diffMonth * 500;
            } else if (diffMonth == 0) {

                if (diffDay >= 0)
                    fine = diffDay * 15;
            }
        }

        return fine;

        // if (diffYear < 0)
        // return 0;

        // return ((diffYear > 0) ? 10000 : (diffMonth > 0) ? diffMonth * 500 : (diffDay
        // > 0) ? diffDay * 15 : 0);
    }

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[2][3];
        for (int i = 0; i < 2; i++) {
            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int j = 0; j < arrItems.length; j++) {
                int arrItem = Integer.parseInt(arrItems[j]);
                arr[i][j] = arrItem;
            }
        }
        System.out.println(printFine(arr));
    }
}
