//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        // Your code here
        //int n =  nums.length;
        if(n == 1)
        {
            return a[0];
        }
        int sum = 0;
        for(int i=0;i<n;i++)  // get the sum of the array
        {
            sum += a[i];
        }
        int cur_max = a[0];
        int cur_min = a[0];
        int max = a[0];
        int min = a[0];
        for(int i=1;i<n;i++)
        {
            cur_max = Math.max(cur_max + a[i],a[i]);
            max = Math.max(max,cur_max);
            cur_min = Math.min(cur_min + a[i],a[i]);
            min = Math.min(min,cur_min); 
        }
        if(min == sum)   // all are negative values
        {
            return max;
        }
        
        return Math.max(max,sum-min); 
    }
    
}

