//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        /*
        // maintain 2 pinters m1 and m2 for both the arrays (initialize -1)
        //  always remember m1 = m2 and m2 is updated in every cases
        // if 1 st arr ele is small then update m2 with 1st array element and increment i
        // else m2 is updated with 2nd arr ele and increment j
        // corner cases are if i==n(1st arr contains all elements smaller than 2 nd) || j==n(2nd 
        arr ele contains all element smaller then 1st) .. so that that array is traversed first
        // in these cases update m2 with the starting of next arr ele and break the loop
        // if i ==n => m2 = a2[0]  || j==n => m2 = a1[0]
        // return m1+m2
        */
        
        int i = 0;  // -> ar1
        int j = 0;  // -> ar2
        int m1 = -1;
        int m2 = -1;
        for(int k=0;k<=n;k++)  // k<=n
        {
            if(i == n)
            {
                m1 = m2;
                m2 = ar2[0];
                break;
            }
            if(j == n)
            {
                m1 = m2;
                m2 = ar1[0];
                break;
            }
            if(ar1[i] < ar2[j])
            {
                m1 = m2;
                m2 = ar1[i];
                i++;
            }
            else
            {
                m1 = m2;
                m2 = ar2[j];
                j++;
            }
        }
        return m1+m2; // sum
    }
}