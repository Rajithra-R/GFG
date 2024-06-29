//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        
        // code here
        HashMap<Character,Integer> h = new HashMap<>();
        h.put('I',1);
        h.put('V',5);
        h.put('X',10);
        h.put('L',50);
        h.put('C',100);
        h.put('D',500);
        h.put('M',1000);
         
        int res = h.get(str.charAt(str.length()-1));
        for(int i = str.length()-2;i>=0;i--)
        {
            if(h.get(str.charAt(i)) < h.get(str.charAt(i+1)) )
            {
                res -= h.get(str.charAt(i));
            }
            else
            {
                res += h.get(str.charAt(i));
            }
        }
        return res;
    }
}