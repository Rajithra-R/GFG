//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        /*
        initially sort both the arrays
        maintain two pointers for 2 arrays
        when 1st array element is less than 2nd , increment i else increment j
        whenever i is incremented that is an arrival happens increase the count
        and whenever j is incremented that is a departure happens decrease the count
        keep a max val to update the number of platforms req
        */
        
        // 2N(LOGN) + O(N)
    
        Arrays.sort(arr); // <- i
        Arrays.sort(dep); // <- j
        int i = 0;
        int j = 0;
        int count = 0;
        int max = 0;
        while(i < n && j < n)
        {
            if(arr[i] <= dep[j])
            {
                i++;
                count++;
            }
            else
            {
                j++;
                count--;
                
            }
            max = Math.max(max,count);
        }
        return max;
    }
    
}

