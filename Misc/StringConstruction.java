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

            int result = new Solution().stringConstruction(s);

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
}