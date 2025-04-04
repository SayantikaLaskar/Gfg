//{ Driver Code Starts
// Initial Template for Java
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
            boolean ans = obj.isCycle(V, edges);
            System.out.println(ans ? "true" : "false");
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends


class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> a=new ArrayList<>();
        for(int i=0; i<V; i++){
            a.add(new ArrayList<>());
        }
        for(int[] e:edges){
            a.get(e[0]).add(e[1]);
            a.get(e[1]).add(e[0]);
        }
        boolean[] v=new boolean[V];
        for(int i=0; i<V; i++){
            if(!v[i]){
                if(b(i, a, v)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean b(int s, List<List<Integer>> a, boolean[] v){
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{s, -1});
        v[s]=true;
        while(!q.isEmpty()){
            int[] n=q.poll();
            int c=n[0];
            int p=n[1];
            for(int ne:a.get(c)){
                if(!v[ne]){
                    v[ne]=true;
                    q.offer(new int[]{ne, c});
                }else if(ne!=p){
                    return true;
                }
            }
        }
        return false;
    }
}