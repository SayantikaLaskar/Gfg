//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int[][] edges = new int[E][2];
            for (int i = 0; i < E; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.isCyclic(V, edges);
            System.out.println(ans ? "true" : "false");
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> g=new ArrayList<>();
        int[] d=new int[V];
        for(int i=0; i<V; i++){
            g.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int u=edges[i][0];
            int v=edges[i][1];
            g.get(u).add(v);
            d[v]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0; i<V; i++){
            if(d[i]==0){
                q.offer(i);
            }
        }
        List<Integer> r=new ArrayList<>();
        while(!q.isEmpty()){
            int n=q.poll();
            r.add(n);
            for(int nb:g.get(n)){
                d[nb]--;
                if(d[nb]==0){
                    q.offer(nb);
                }
            }
        }
        return r.size()!=V;
    }
}