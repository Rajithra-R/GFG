//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        int left = 0;
        int right = 0;
        int max_len = 0;
        HashMap<Integer,Integer> h = new HashMap<>();
        for(right = 0;right < fruits.length;right++)
        {
            // add each friut into the hash(basket)
            h.put(fruits[right],h.getOrDefault(fruits[right],0)+1);
            //check if the basket has more than 2 elements
            // if so get its count and decrement it if count is 1 then remove the ele from the basket and then slide the window
            while(h.size() > 2)
            {
                int count = h.get(fruits[left]);
                if(count == 1)
                {
                    h.remove(fruits[left]);
                }
                else
                {
                    h.put(fruits[left],count - 1);
                }
                left++;
            }
            max_len = Math.max(max_len,right- left + 1);
        }
        return max_len;
    }
}