//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int visited[] = new int[V];
        int pathvisited[] = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i] == 0)
            {
                if(dfs(i,adj,visited,pathvisited)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int i,ArrayList<ArrayList<Integer>> adj,int visited[],int pathvisited[])
    {
        visited[i] = 1;
        pathvisited[i] = 1;
        
        for(int j : adj.get(i)) // get neighbouring nodes
        {
            if(visited[j] == 0)
            {
                if(dfs(j,adj,visited,pathvisited)) return true;
            }
            else if(pathvisited[j] == 1) return true;
        }
        pathvisited[i] = 0;
        return false;
    }
}