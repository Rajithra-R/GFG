//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            long res = obj.solve(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int solve(int n, int m, int grid[][]) {
        // Code here
        int dp[][][] = new int[n][m][m];
        for (int i = 0; i < dp.length; i++)
        {
             for (int j = 0; j < dp[i].length; j++) 
             {
                Arrays.fill(dp[i][j], -1);
             }
        }
        return Chocolate(0,0,m-1,n,m,grid,dp);
    }
    static int Chocolate(int i,int j1,int j2,int n,int m,int[][] grid,int[][][] dp)
    {
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m ) 
        {
            return (int) (Math.pow(-10,9));
        }
        
        if(i == n-1) // last row
        {
            if(j1 == j2) // both have took the same chocolate
            {
                return grid[i][j1];
            }
            else  // sum both chocolates
            {
                return grid[i][j1] + grid[i][j2];
            }
        }
        
        if(dp[i][j1][j2] != -1)
        {
            return dp[i][j1][j2];
        }
        
        int max = Integer.MIN_VALUE;
        for(int p=-1;p<=1;p++) // can move in 3 dir => -1,0,1  => for each p(i.e,-1) , have 3 q(i.e,-1,0,1)
        {
            for(int q=-1;q<=1;q++)   // can move in 3 dir => -1,0,1
            {
                int ans;
                if(j1 == j2)
                {
                    ans = grid[i][j1] + Chocolate(i+1,j1+p,j2+q,n,m,grid,dp);
                }
                else
                {
                    ans = grid[i][j1] + grid[i][j2] + Chocolate(i+1,j1+p,j2+q,n,m,grid,dp);
                }
                max = Math.max(max,ans);
            }
        }
        return dp[i][j1][j2] = max;
    }
    
}