import java.util.*;

public class StringReverseWord {
    public static String reverseStringWord(String s)
    {
        String[] content = s.split(" ",-2);
        int length = content.length;
        String[] reversed = new String[length];
        
        for(int i = 0; i < length; i++)
        {
            reversed[i] = content[length-1-i];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < reversed.length; i++)
        {
            if(i == reversed.length -1 )
                sb.append(reversed[i]);
            else
                sb.append(reversed[i]+" ");
        }

        return sb.toString();
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
            System.out.println(reverseStringWord(arrString[i]));   
        }
        in.close();

    }
}