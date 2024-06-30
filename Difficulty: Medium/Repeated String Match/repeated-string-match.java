//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t > 0) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A, B));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static int repeatedStringMatch(String a, String b) {
        // Your code goes here
        int n  = b.length() / a.length();
        String s = a;  // substring that hold the initial 1st string
        int count = 1; // include the 1st string initially  
        for(int i =0;i<n+2;i++)
        {
            if(s.contains(b))   
      // at some cond it will definitely fall in this base case as we compare using s a new var
            {
                return count;
            }
            else
            {
                s = s+a; // add 1st string second time to a
                count++;  // further addition is done  in s and the counter is incremented
            }
        }
        return -1;
    }
}
