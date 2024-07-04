//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s = br.readLine();
            Solution obj = new Solution();
            System.out.println(obj.maxOdd(s));
        }
    }
}
// } Driver Code Ends


class Solution {

    String maxOdd(String s) {
        // code here
         int max = 0;
        int flag = 0;
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)-'0') % 2 == 1) // odd
            {
                flag = 1;
                max = i;
            }
        }
        if(flag == 0) // no odd num exists
        {
            return "";
        }
        return s.substring(0,max+1);  // since last index is exclusive
        
    }
}