//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int sizeOfArray = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);

            int arr[] = new int[sizeOfArray];

            line = br.readLine();
            String[] elements = line.trim().split("\\s+");
            for (int i = 0; i < sizeOfArray; i++) {
                arr[i] = Integer.parseInt(elements[i]);
            }

            Solution obj = new Solution();
            int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function
       HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int max_len = 0;
        
        // Traverse through the array
        for (int i = 0; i < N; i++) {
            // Add the current element to the sum
            sum += A[i];
            
            // Check if the sum itself is equal to K
            if (sum == K) {
                max_len = i + 1;
            }
            
            // If (sum - K) is found in the map, we have a subarray of sum K
            if (map.containsKey(sum - K)) {
                max_len = Math.max(max_len, i - map.get(sum - K));
            }
            
            // Only add the current sum to the map if it is not already present
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return max_len;
    }
}
/* GENERATE ALL SUBARRAYS
  ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                ArrayList<Integer> subarray = new ArrayList<>();

                for(int k=i;k<=j;k++)
                {
                    subarray.add(A[k]);
                   
                }
                res.add(subarray);
            }
        }
*/

/* BRUTE FORCE - O(n^3)
 int max_len = 0;
      for(int i=0;i<N;i++)
        {
            for(int j=i;j<N;j++)
            {
                int sum = 0;
                for(int k=i;k<=j;k++)
                {
                    sum += A[k];
                    if(sum == K)
                    {
                        max_len = Math.max(max_len,j-i);
                    }
                }
            }
            
        }
        return max_len;
*/

/*BRUTE FORCE - O(n^2)
 int max_len = 0;
      for(int i=0;i<N;i++)
        {
             int sum = 0;
            for(int j=i;j<N;j++)
            {
                    sum += A[j];
                    if(sum == K)
                    {
                        max_len = Math.max(max_len,j-i+1);
                    }
                
            }
            
        }
        return max_len;
*/