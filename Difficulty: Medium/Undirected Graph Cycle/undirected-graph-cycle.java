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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends

// BFS => MARK VISITED AND ADD TO THE QUEUE


class Solution {
    static class Pair{
        int node,parent;
        Pair(int node,int parent)
        {
            this.node = node;
            this.parent = parent;
        }
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int i=0;i<V;i++)
        {
            if(visited[i] == 0)
            {
                if(checkCycle(V,adj,visited,i)) return true;  // to check all the connected components also...
            }
        }
        return false;
    }
    public boolean checkCycle(int V, ArrayList<ArrayList<Integer>> adj,int[] visited,int i)
    {
        visited[i] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,-1)); // for ist node parent = -1;
        while(!q.isEmpty())
        {
            int node = q.peek().node;
            int parent = q.peek().parent;
            q.remove();
            // take the adjacency list of that node
            for(int adjnode : adj.get(node))
            {
                if(visited[adjnode] == 0)
                {
                    visited[adjnode] = 1;
                    q.add(new Pair(adjnode,node));
                }
                else if(parent != adjnode)  // the node is already visited 
                // either the visited node is a parent node or it is a node with cycle
                {
                    return true;
                }
            }
        }
        return false;
    }
}