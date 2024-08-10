//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long N = sc.nextLong();

            Solution ob = new Solution();
            ArrayList<Long> ans = ob.factorialNumbers(N);
            for (long num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static ArrayList<Long> factorialNumbers(long n) {
       ArrayList<Long> res = new ArrayList<>();
        long fact = 1;
        int i = 1;
        
        // Compute factorials and add them to the result list if they are less than n
        while (fact < n) {
            res.add(fact);
            i++;
            fact *= i;
        }
        
        // Special case: If n > 1, include the factorial of i-1
        if (fact == n) {
            res.add(fact);
        }
        
        return res;
    }
}