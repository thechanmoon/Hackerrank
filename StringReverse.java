import java.util.*;

public class StringReverse {
    public static String reverseString(String s)
    {
        char[] content = s.toCharArray();
        int length = content.length;
        char[] reversed = new char[length];
        
        for(int i = 0; i < length; i++)
        {
            reversed[i] = content[length-1-i];
        }
        
        return new String(reversed);
    }
    
    public static String reverseStringBuffer(String s)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        return new String(sb.reverse());
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String[] arrString = new String[n];
        for (int i = 0; i < n; i++) {
            arrString[i] = in.nextLine();  
        }
    
        for (int i = 0; i < n; i++) {
            System.out.println(reverseStringBuffer(arrString[i]));   
        }
        in.close();

    }
}