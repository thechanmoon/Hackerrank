import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class IslandMatrix {
    private static final Scanner scanner = new Scanner(System.in);

    public static int numIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIsland = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    numIsland += dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    public static int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        dfs(grid, i + 1, j + 1);
        dfs(grid, i + 1, j - 1);
        dfs(grid, i - 1, j + 1);
        dfs(grid, i - 1, j - 1);

        return 1;
    }

    public static void main(String[] args) {

        String[] arrayLen = scanner.nextLine().split(" ");

        int n = Integer.parseInt(arrayLen[0]);
        int m = Integer.parseInt(arrayLen[1]);

        int[][] arr = new int[n][m];

        for (int i = 0; i < arr.length; i++) {
                String[] arrRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < arr[i].length; j++) {
                        int arrItem = Integer.parseInt(arrRowItems[j]);
                        arr[i][j] = arrItem;
                }
        }

        System.out.println(numIsland(arr));
        scanner.close();
    }
}