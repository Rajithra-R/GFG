//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            boolean res = obj.isFrequencyUnique(n, arr);
            
            int _result_val = (res) ? 1 : 0;
            System.out.println(_result_val);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        // code here
        Map<Integer,Integer> h1 = new HashMap<>();
        for(int i : arr)
        {
            h1.put(i,h1.getOrDefault(i,0) + 1);
        }
        Set<Integer> h2 = new HashSet<>(); // to check for Unique Number of Occurrences
        for(int i : h1.values())
        {
            if(!h2.add(i)) // add() returns false if the value already exist
            {
                return false;
            }
        }
        return true;
    }
}
        
