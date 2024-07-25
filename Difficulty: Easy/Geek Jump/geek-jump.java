//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumEnergy(int arr[],int N){
        //code here
        int prev1 = 0;
        int prev2 = 0;
        for(int i=1;i<N;i++)
        {
            int fs = prev1 + Math.abs(arr[i] - arr[i-1]); // first step
            int ss = Integer.MAX_VALUE;
            if(i>1)
            {
                 ss = prev2 + Math.abs(arr[i] - arr[i-2]); // sec step
            }
            int cur = Math.min(fs,ss);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}