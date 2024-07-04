//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            long ans = obj.maxScore(a, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static long maxScore(int cardPoints[], int N, int k) {
        // code here
        int lsum = 0;
        int rsum = 0;
        int sum = 0;
        int max = 0;
        // initially we do sum up k elements from the front
        for(int i =0;i<k;i++)
        {
            lsum += cardPoints[i];
            max = Math.max(max,lsum);
        }
        //remove 1 from front and add 1 at the back
       // int n = cardPoints.length;
        int right = N-1;
        for(int i=k-1;i>=0;i--)
        {
            lsum -= cardPoints[i];
            rsum += cardPoints[right];
            right--;  // add further elements from the end
            sum = lsum + rsum;
            max = Math.max(max,sum);
        }
        return max;
    
    }
}
