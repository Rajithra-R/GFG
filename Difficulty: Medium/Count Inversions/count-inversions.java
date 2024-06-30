//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long arr[], int n) {
        // Your Code Here
         long inv_count = 0;
        inv_count = mergeSortAndCount(arr, 0, n - 1);
        return inv_count;
    }
    private static long mergeSortAndCount(long[] k, int start, int finish) {
        long inv_count = 0;
        int size = finish - start + 1;
        if (size <= 1)
            return inv_count;
        
        int mid = start + (size / 2) - 1;
        inv_count += mergeSortAndCount(k, start, mid);
        inv_count += mergeSortAndCount(k, mid + 1, finish);
        inv_count += two_way_merge(k, start, mid + 1, finish);

        return inv_count;
    }

    // Function to merge two halves and count split inversions
    private static long two_way_merge(long k[], int fir, int sec, int third) {
        long temp[] = new long[third - fir + 1];
        int i = fir;
        int j = sec;
        int l = 0;
        long inv_count = 0;
        
        while (i < sec && j <= third) {
            if (k[i] <= k[j]) {
                temp[l] = k[i];
                l++;
                i++;
            } else {
                temp[l] = k[j];
                l++;
                j++;
                inv_count += (sec - i); // All remaining elements in the left half are greater than k[j]
            }
        }
        
        while (i < sec) {
            temp[l] = k[i];
            l++;
            i++;
        }
        
        while (j <= third) {
            temp[l] = k[j];
            l++;
            j++;
        }
        
        for (int m = 0; m < l; m++) {
            k[fir + m] = temp[m];
        }
        
        return inv_count;
    }
}