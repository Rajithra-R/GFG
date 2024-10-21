//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(a, b);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// a,b : the arrays
class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        ArrayList<Integer> res = new ArrayList<>();
        int i=0,j=0;
        while(i < a.length && j < b.length)
        {
          if(a[i] < b[j])
          {
              if(res.isEmpty() || res.get(res.size()-1) != a[i])
              {
                 res.add(a[i]); 
              }
              i++;
          }
          else if(b[j] < a[i])
            {
               if(res.isEmpty() || res.get(res.size()-1) != b[j])
                { 
                res.add(b[j]);
                }
                j++;
            }
            else
            {
                if(res.isEmpty() || res.get(res.size()-1) != a[i])
                  {
                     res.add(a[i]); 
                  }
                  i++;
                  j++;
            }
        }
        while(i < a.length)
        {
              if(res.isEmpty() || res.get(res.size()-1) != a[i])
              {
                 res.add(a[i]); 
              }
              i++;
        }
        while(j < b.length)
        {
             if(res.isEmpty() || res.get(res.size()-1) != b[j])
                { 
                  res.add(b[j]);
                }
                j++;
        }
        return res;
    }
}

/* TreeSet => log n

        Set<Integer> h = new TreeSet<>(); // automatically sorts and remove duplicates
        int i=0,j=0;
        while(i < a.length && j < b.length)
        {
            if(a[i] < b[j])
            {
                h.add(a[i]);
                i++;
            }
            else if(b[j] < a[i])
            {
                h.add(b[j]);
                j++;
            }
            else
            {
                h.add(a[i]);
                i++;
                j++;
            }
        }
        while(i < a.length)
        {
            h.add(a[i]);
            i++;
        }
        while(j < b.length)
        {
            h.add(b[j]);
            j++;
        }
         ArrayList<Integer> res = new ArrayList<>(h);
         return res;
*/
