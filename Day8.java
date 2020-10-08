
//Complete this code or write your own from scratch
import java.util.*;
import java.io.*;

class Day8 {

    static HashMap<String, Integer> phonebook = new HashMap<String, Integer>();

    public static void main(String[] argh) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phonebook.put(name, phone);
        }
        while (in.hasNext()) {
            String s = in.next();
            // Write code here
            Integer value = phonebook.get(s);
            if (value == null)
                System.out.println("Not found");
            else
                System.out.println(s + "=" + value);
        }
        in.close();
    }
}