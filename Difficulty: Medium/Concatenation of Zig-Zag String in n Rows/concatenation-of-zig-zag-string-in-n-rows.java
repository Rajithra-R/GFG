//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    int n=sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.convert(s,n));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String convert(String s, int n)
    {
        //code here
       int m= s.length();
        char arr[][] = new char[n][m];
        int row = 0;
        int col =0;
        int cur =0;
        while( cur < m)
        {
            while(row < n && cur < m)
            {
                arr[row][col] = s.charAt(cur);
                row++;
                cur++;
            }
            row = Math.max(0,row-2);
            while(row > 0 && cur < m)
            {
                arr[row--][++col] = s.charAt(cur++); // row is decremented to move up,col is firstly incremented because initially it is at col 0 but my first value comes in at only col 1
            }
            col++;
        }
        StringBuilder res = new StringBuilder();
        for(int i =0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(arr[i][j] != 0)
                {
                res.append(arr[i][j]);
                }
            }
        }
        return res.toString();
        
    }
}