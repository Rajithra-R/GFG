//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
       // int m = board.length;
        //int n = board[0].length;
        char board[][] = a;
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int visited[][] = new int[n][m];
        
        // based on row
        for(int j=0;j<m;j++)  // any col
        {
            // 1st row
            if(visited[0][j] == 0 && board[0][j] == 'O')
            {
                dfs(0,j,n,m,drow,dcol,board,visited);
            }
            // last row
            if(visited[n-1][j] == 0 && board[n-1][j] == 'O')
            {
                dfs(n-1,j,n,m,drow,dcol,board,visited);
            }
        }
        
        // based on col
        for(int i=0;i<n;i++) // any row
        {
            // 1st col
            if(visited[i][0] == 0 && board[i][0] == 'O')
            {
                dfs(i,0,n,m,drow,dcol,board,visited);
            }
            // last col
            if(visited[i][m-1] == 0 && board[i][m-1] == 'O')
            {
                dfs(i,m-1,n,m,drow,dcol,board,visited);
            }
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(visited[i][j] == 0 && board[i][j] == 'O')
                {
                    board[i][j] = 'X';
                }
            }
        }
        return board;
    }
    public static void dfs(int row,int col,int n,int m,int[] drow,int[] dcol,char board[][],int visited[][])
    {
        visited[row][col] = 1;
        // neighbours
        for(int i=0;i<4;i++)
        {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] == 0 && board[nrow][ncol] == 'O')
            {
                dfs(nrow,ncol,n,m,drow,dcol,board,visited);
            }
        }
    }
}