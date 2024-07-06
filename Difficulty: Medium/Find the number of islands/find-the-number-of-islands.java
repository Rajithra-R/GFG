//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        if(row == 0)  return 0;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(grid[i][j] == '1') // then  increment the count and mark all its neighbours
                {
                    count++;
                    MarkNeighbours(grid,i,j,row,col);
                }
            }
        }
        return count;
    }
    private void MarkNeighbours(char grid[][],int i,int j,int row,int col)
    {
        if(i < 0 || j < 0 || i >= row || j >= col|| grid[i][j] != '1')
        {
            return;
        }
        grid[i][j] = '0';  // u can use any number to mark the neighbours
        MarkNeighbours(grid,i-1,j,row,col); // up
        MarkNeighbours(grid,i+1,j,row,col); //down
        MarkNeighbours(grid,i,j-1,row,col); //left
        MarkNeighbours(grid,i,j+1,row,col); //right
        MarkNeighbours(grid, i - 1, j - 1, row, col); // up-left
        MarkNeighbours(grid, i - 1, j + 1, row, col); // up-right
        MarkNeighbours(grid, i + 1, j - 1, row, col); // down-left
        MarkNeighbours(grid, i + 1, j + 1, row, col); // down-right
    }
}