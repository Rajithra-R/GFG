//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.KoKoEat(arr, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int KoKoEat(int[] arr, int k) {
        // code here
        int piles[] = arr;
        int h = k;
        int max = piles[0];
        int ans = Integer.MAX_VALUE;
        for(int i : piles)
        {
            max = Math.max(max,i);
        }
        int low = 1;
        int high = max;
        while(low <= high)
        {
            int mid = (low+high)/2;
            int totaltime = Find(piles,mid);
            if(totaltime <= h)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }
    public static int Find(int piles[],int hour)
    {
        int totaltime = 0;
        for(int i=0;i<piles.length;i++)
        {
            totaltime += Math.ceil((double)piles[i]/(double)hour);
        }
        return totaltime;
    }
}
