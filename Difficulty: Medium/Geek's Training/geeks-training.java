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
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr, N);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][], int N) {
        // code here
       int M = arr[0].length;  // Number of activities
        int[][] dp = new int[N][M];
        
        // Initialize the first day's dp values
        for (int j = 0; j < M; j++) {
            dp[0][j] = arr[0][j];
        }
        
        // Fill the dp table for the rest of the days
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // Calculate max points possible for dp[i][j]
                int maxVal = Integer.MIN_VALUE;
                for (int k = 0; k < M; k++) {
                    if (k != j) {  // Ensure no consecutive activity
                        maxVal = Math.max(maxVal, dp[i-1][k]);
                    }
                }
                dp[i][j] = arr[i][j] + maxVal;
            }
        }
        
        // Find the maximum value on the last day
        int maxPoints = Integer.MIN_VALUE;
        for (int j = 0; j < M; j++) {
            maxPoints = Math.max(maxPoints, dp[N-1][j]);
        }
        
        return maxPoints;
    }
}