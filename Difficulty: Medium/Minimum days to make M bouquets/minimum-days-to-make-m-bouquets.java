//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int M, int K, int[] bloomDay) {
        int m = M;
        int k = K;
      int n = bloomDay.length;
        if(n < m*k) return -1;
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++)
        {
            min = Math.min(min,bloomDay[i]);
            max = Math.max(max,bloomDay[i]); 
        }
        
        int low = -1;
        int high = max;
        
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(possible(bloomDay,mid,m,k))
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return possible(bloomDay, low, m, k) ? low : -1; // again once confirm it
    }
    public static boolean possible(int[] bloomDay,int val,int m, int k)
    {
        int c = 0;
        int no_of_day = 0;
        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] <= val)
            {
                c++;
            }
            else
            {
                 no_of_day += (c/k);
                c = 0;
            }
        }
        no_of_day += (c/k); // if only blooms and no other non blooms after the bloom,to include that
        return no_of_day >= m;
        
    }
}