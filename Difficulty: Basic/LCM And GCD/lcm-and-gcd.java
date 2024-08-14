//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    static Long[] lcmAndGcd(Long A , Long B) {
        // code here
        Long gcdval = GCD(A,B);
        Long lcmval = LCM(A,B,gcdval);
        return new Long[]{lcmval,gcdval};
    }
    public static Long GCD(Long A , Long B)
    {
        while(B != 0)
        {
            Long temp = B;
            B = A % B;
            A = temp;
        }
        return A;
    }
    public static Long LCM(Long A , Long B,Long gcdval)
    {
        return (Long) (A*B)/gcdval;
    }
};