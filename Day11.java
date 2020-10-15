import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day11 {

    private static final Scanner scanner = new Scanner(System.in);

    static int calcSum(int[][] arr) {
        int max = 0;
        int sum = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = 0; j < arr[i].length - 2; j++) {
                sum = calcHourGlassSum(arr, i, j);
                if ((i == 0 && j == 0) || sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    static int calcHourGlassSum(int[][] arr, int row, int col) {
        int sum = 0;

        // System.out.println("row : " + row);
        // System.out.println("col : " + col);

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (row == 3 && col == 2) {
                    // System.out.println("arr["+i+"]["+j+"] = "+arr[i][j]);

                    // System.out.println("row : " + row);
                    // System.out.println("col : " + col);
                }
                if (i == row || i == row + 2 || (i == row + 1 && j == col + 1)) {
                    sum += arr[i][j];
                }
            }
        }
        // if(row==3 && col ==2)
        // {
        // System.out.println("Sum = " + sum);
        // }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }
        scanner.close();
        // int[][] arr1 = { { 1, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0 }, { 1, 1, 1, 0, 0,
        // 0 }, { 0, 0, 2, 4, 4, 0 }, { 0, 0, 0, 2, 0, 0 }, { 0, 0, 1, 2, 4, 0 } };

        int[][] arr1 = { { -1, -1, 0, -9, -2, -2 }, { -2, -1, -6, -8, -2, -5 }, { -1, -1, -1, -2, -3, -4 },
                { -1, -9, -2, -4, -4, -5 }, { -7, -3, -3, -2, -9, -9 }, { -1, -3, -1, -2, -4, -5 } };
        System.out.println(calcSum(arr1));
    }
}
