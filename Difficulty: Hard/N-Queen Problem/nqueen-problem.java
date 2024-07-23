//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        // Initialize the board with '.' (empty cells)
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Arrays to keep track of attacks on rows and diagonals
        int[] leftRow = new int[n];
        int[] upDiagonal = new int[2 * n - 1];
        int[] lowDiagonal = new int[2 * n - 1];

        // Start solving the problem from the first column
        solve(0, board, res, leftRow, upDiagonal, lowDiagonal);

        return res;
    }

    private static void solve(int col, char[][] board, ArrayList<ArrayList<Integer>> res, int[] leftRow, int[] upDiagonal, int[] lowDiagonal) {
        // If all queens are placed, add the board configuration to the result
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if it's safe to place the queen
            if (leftRow[row] == 0 && lowDiagonal[row + col] == 0 && upDiagonal[board.length - 1 + col - row] == 0) {
                // Place the queen
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowDiagonal[row + col] = 1;
                upDiagonal[board.length - 1 + col - row] = 1;

                // Recur to place the rest of the queens
                solve(col + 1, board, res, leftRow, upDiagonal, lowDiagonal);

                // Backtrack and remove the queen
                board[row][col] = '.';
                leftRow[row] = 0;
                lowDiagonal[row + col] = 0;
                upDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    // Construct the board configuration to a list of integer lists
    private static ArrayList<Integer> construct(char[][] board) {
        ArrayList<Integer> res = new ArrayList<>();
        
            for (int j = 0; j < board.length; j++) {
                for (int i = 0; i < board.length; i++) {
                if (board[i][j] == 'Q') {
                    res.add(i+ 1); // Adding 1 for 1-based index
                    break;
                }
            }
        }
        return res;
    }
}