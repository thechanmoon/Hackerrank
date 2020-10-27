import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class WordCound {

    private static final int MOD = 1000000007;

    static int countWord(int wordLen, int maxVowels) {
        int[][] dp = new int[wordLen + 1][2];

        dp[0][1] = dp[0][0] = 1;
        dp[1][1] = 21;
        dp[1][0] = 5;

        for (int i = 2; i <= wordLen; i++) {

            dp[i][1] = (21 * (dp[i - 1][1] + dp[i - 1][0]) % MOD) % MOD;

            int k = i, j = 1, p = 5;
            dp[i][0] = 0;

            while (k > 0 && j <= maxVowels) {
                dp[i][0] = (dp[i][0] + (p * dp[i - j][1]) % MOD) % MOD;
                p = (p * 5) % MOD;
                k--;
                j++;
            }
        }

        return (int) (dp[wordLen][0] + dp[wordLen][1]) % MOD;
    }

    public static void main(String[] args) {
        System.out.println(countWord(5, 2));
    }
}