//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int K) {
        int c = 0;
        int mid = 0;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        int threshold = K;
        for(int k=0;k<nums.length;k++)
        {
             max = Math.max(max,nums[k]);
        }
        int low = 1;
        int high = max;
        while(low <= high)
        {
            mid = (low+high)/2;
            if(sum_of_div(nums,mid) <= threshold)  // if u get an answer then look for a little small value if possible
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int sum_of_div(int nums[],int mid)
    {
        int sum = 0;
        for(int i =0;i<nums.length;i++)
        {
            sum += Math.ceil((double)nums[i] /(double) mid);
        }
        return sum;
    
    }
}