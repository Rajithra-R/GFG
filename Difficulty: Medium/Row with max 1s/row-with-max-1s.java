//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int ans = new Solution().rowWithMax1s(arr);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/* 
u can approach by naive => that takes mxn time complexity
loop each row ,  keep a count var , loop each col , update count ,
come out of j loop , update the max_count and make index to i.

binary search =>

for each row apply binary search  to spot the first occurence =>
if middle ele >= 1 the update index and look for left side for any futher 1
if middle ele < 1 i.e 0 move right and search for 1

here cnt is calculated as that => 
in an array 0 0 1 1 1 => count of 1 = total ele i.e n - first occurence of 1 => 5-2 = 3.

*/



class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int m = arr.length; // row
        int n = arr[0].length; // col
        int max_count = 0;
        int index_of_1 = -1;
        for(int i=0;i<n;i++)
        {
            int cnt = n - first_occur(arr[i],n,1); // since we need first occur of 1
            if(cnt > max_count)
            {
                max_count = cnt;
                index_of_1 = i;
            }
        }
        return index_of_1;
    }
    
    public int first_occur(int a[],int n,int x)
    {
    int low = 0;
    int high = n-1;
    int index = n;
    // initially index = n beacuse if no 1 is found then it will return no.of.col so that count become  n-n = 0 => no one found
    while(low <= high)
    {
        int mid = (low+high)/2;
        if(a[mid] >= x)
        {
            index = mid;
            high = mid - 1;
        }
        else
        {
            low = mid + 1;
        }
    }
    return index;
    }
}