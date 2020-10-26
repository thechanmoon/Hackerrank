import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Day25 {

    public static boolean isPrime(int number)
    {
        if ( number < 2 )
            return false;
        // for(int i = 2; i < number; i++)
        // {
        //     if(number%i == 0)
        //         return false;
        // }
        // return true;
        int sqrt = (int) Math.sqrt(number) + 1;
        for (int i = 2; i < sqrt; i++) 
        { 
            if (number % i == 0)
            { 
                return false; 
            } 
        } 
        return true;
    }

    public static void main(String[] args) {
        /* Enter your code here. */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int i = 0; i < array.length; i++) {
            if(isPrime(array[i]))
                System.out.println("Prime");
            else
                System.out.println("Not prime");
        }   
    }
}



