//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        int n = mat.length;
        int visited[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                visited[i][j] = 0;
            }
        }
        int di[] = {+1,0,0,-1}; 
        int dj[] = {0,-1,+1,0};
        //down - i+1,j
        //left - i,j-1
        //right - i,j+1
        //up - i-1,j
        if(mat[0][0] == 1)
        {
            solve(0,0,mat,n,res,"",visited,di,dj);
        }
        return res;
    }
    public static void solve(int i,int j,int mat[][],int n,ArrayList<String> res,String s,int visited[][],int di[],int dj[])
    {
        String str = "DLRU";
        if(i == n-1 && j== n-1) // reached the end of the matrix
        {
            res.add(s);
            return;
        }
        for(int k=0;k<4;k++) // 4 directions
        {
            int nexti = i + di[k];
            int nextj = j + dj[k];
            if(nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && visited[nexti][nextj] == 0 && mat[nexti][nextj] == 1)
            {
                visited[i][j] = 1;
                solve(nexti,nextj,mat,n,res,s+str.charAt(k),visited,di,dj);
                visited[i][j] = 0;
            }
        }
    }
}