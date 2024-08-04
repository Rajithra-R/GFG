//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int choice = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            List<Double> arr = new ArrayList<Double>();
            for(int i = 0;i < choice;i++)
                arr.add(Double.parseDouble(a[i]));
            
            Solution ob = new Solution();
            if(choice == 1)
                System.out.println(String.format("%.2f", ob.switchCase(choice, arr)));
            else
                System.out.println((int)ob.switchCase(choice, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static double switchCase(int choice, List<Double> arr){
        // code here
         double res = 0;
        int[][] a = new int[2][2];

        // Increment each element of the array 'a'
        

        switch (choice) {
            case 1:
                if(arr.size() == 1)
                {
                double rad = arr.get(0) * arr.get(0);
                res = Math.PI * rad; // Area of a circle with radius a[0][0]
                }
                break;
                
            case 2:
                if(arr.size() == 2)
                {
                res = arr.get(0) *arr.get(1); // Product of a[1][0] and a[1][1]
                }
                break;
            
        }

        return res;
    }
}


/*double res = 0;
        int[][] a = new int[2][2];
        for(int[] k : a)
        {
            int x = k[0];
            int y = k[1];
            a[x][y]++;
        }
        switch(choice)
        {
            case 1:
                res = Math.PI * a[0][0] * a[0][0];
                break;
            case 2:
                res = a[1][0] * a[1][1];
                break;
        }
        return res;*/