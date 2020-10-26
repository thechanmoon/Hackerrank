import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Day28 {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, String> hash = new HashMap<>();
        String emailRegEx = ".+@gmail\\.com$";
        Pattern pattern = Pattern.compile(emailRegEx);

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];

            Matcher matcher = pattern.matcher(emailID);
            if (matcher.find()) {
                hash.put(emailID, firstName);
            }

        }

        String[] names = new String[hash.size()];
        int index = 0;
        Iterator it = hash.entrySet().iterator();

        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            // if(pair.getKey().toString().contains("@gmail.com"))
            names[index++] = pair.getValue().toString();
            it.remove();
        }
        Arrays.sort(names);
        for (int i = 0; i < index; i++) {
            System.out.println(names[i]);
        }
        scanner.close();
    }
}
