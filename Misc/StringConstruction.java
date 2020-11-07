import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class StringConstruction {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            // int result = new Solution().stringConstruction(s);
            // int result = new Solution().stringConstructionUsingArray(s);
            int result = new Solution().stringConstructionUsingBitVector(s);

            // bufferedWriter.write(String.valueOf(result));
            // bufferedWriter.newLine();
            System.out.println(Integer.toString(result));
        }

        // bufferedWriter.close();

        scanner.close();
    }
}

class Solution {

    // Complete the stringConstruction function below.
    int stringConstruction(String s) {

        if (s.length() == 0)
            return 0;

        int count = 0;
        StringBuilder sb = new StringBuilder();

        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (sb.toString().contains(String.valueOf(ch[i])) == false) {
                sb.append(ch[i]);
                count++;
                continue;
            }
        }
        return count;
    }

    int stringConstructionUsingArray(String s) {

        if (s.length() == 0)
            return 0;

        int count = 0;
        int[] ascii = new int[26];

        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int index = ch[i] - 'a';
            if (ascii[index] == 0) {
                ascii[index]++;
                count++;
                continue;
            }
        }
        return count;
    }

    static int stringConstructionUsingBitVector(String s) {

        if (s.length() == 0)
            return 0;

        int count = 0;
        int BitVector = 0;

        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int index = ch[i] - 'a';
            if ((BitVector & (1 << index)) == 0) {
                BitVector |= (1 << index);
                count++;
                continue;
            }
        }
        return count;
    }
}