using System;
using System.Collections.Generic;
using System.IO;
class IslandMatrix {
    
    static int numIsland(int[][] grid)
    {
        if(grid == null || grid.Length == 0)
        {
            return 0;
        }

        int numIsland = 0;

        for(int i = 0; i < grid.Length; i++){
            for(int j = 0; j < grid[0].Length; j++){
                if(grid[i][j] == 1){
                    numIsland += dfs(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    static int dfs(int[][] grid, int i, int j)
    {
        if(i < 0 || i >= grid.Length || j < 0 || j >= grid[i].Length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j );
        dfs(grid, i, j + 1 );
        dfs(grid, i, j - 1 );

        dfs(grid, i + 1, j + 1 );
        dfs(grid, i + 1, j - 1 );
        dfs(grid, i - 1, j + 1 );
        dfs(grid, i - 1, j - 1 );

        return 1;
    }
    
    static void Main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
        int[] arrayMatrix = Array.ConvertAll(Console.ReadLine().Split(' '), arrTemp => Convert.ToInt32(arrTemp));
        
        int n = arrayMatrix[0];
        int m = arrayMatrix[1];
        int[][] arr = new int[n][];

        for (int i = 0; i < n; i++) {
            arr[i] = Array.ConvertAll(Console.ReadLine().Split(' '), arrTemp => Convert.ToInt32(arrTemp));
        }
        
        System.Console.WriteLine(numIsland(arr));
    }
}