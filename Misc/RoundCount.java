import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RoundCount {
    private static int[][] dp;// = new int[100][100];

    private static void initDP(int row, int col, int num) {
        dp = new int[row][col];
        for (int[] arr1 : dp)
            Arrays.fill(arr1, num);
    }

    // private static void backtrack(int[] path,int pos,int fuel,int[] arr){
    // if(fuel<0)return;
    // if(pos>arr.length)return;
    // if(pos==arr.length){
    // ans.push_back(path);
    // return;
    // }
    // for(int i=pos;i<arr.length;i++){
    // int prevpos = path.back();
    // path.push_back(i);
    // int curfuel = abs(arr[i]-arr[prevpos]);
    // backtrack(path,i+1,fuel-curfuel,arr);
    // path.pop_back();
    // }
    // }

    private static int dfs(int fuel, int pos, int[] arr, int lastpos) {
        if (fuel < 0)
            return 0;
        if (pos == arr.length) {
            return 1;
        }
        if (dp[fuel][pos] != -1)
            return dp[fuel][pos];
        int ans = 0;
        for (int i = pos; i < arr.length; i++) {
            int curfuel = Math.abs(arr[i] - arr[lastpos]);
            ans += dfs(fuel - curfuel, i + 1, arr, i);
        }
        return dp[fuel][pos] = ans;
    }

    public static void main(String[] args) {
        int[] array = { 1, 3, 6, 2, 4 };
        int fuel = 7;

        // Arrays.stream(dp).forEach(a -> {
        // Arrays.fill(a, -1);
        // });
        // dp = new int[fuel + 1][array.length + 1];

        initDP(fuel + 1, array.length + 1, -1);

        System.out.println(dfs(fuel, 1, array, 0));

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                // if (dp[i][j] != -1)
                System.out.print(i + "," + j + "=" + dp[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}