import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinMaxSum {
    // Complete the miniMaxSum function below.
    static void miniMaxSum(int[] arr) {
        if (arr == null || arr.length < 1)
            return;
        long sum = 0, min = 0, max = 0;
        long array_sum[] = new long[arr.length];
        for (int n : arr) {
            sum += n;
        }
        // sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            array_sum[i] = sum - arr[i];
        }
        min = max = array_sum[0];
        for (int i = 1; i < array_sum.length; i++) {
            if (array_sum[i] < min)
                min = array_sum[i];
            if (array_sum[i] > max)
                max = array_sum[i];
        }
        System.out.println(min + " " + max + " ");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = new int[5];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        miniMaxSum(arr);
        scanner.close();
    }
}