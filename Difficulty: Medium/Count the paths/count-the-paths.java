class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        // Code here
        int[] dp=new int[V];
        ArrayList<Integer>[] g=new ArrayList[V];
        for(int i=0; i<V; i++){
            g[i]=new ArrayList<>();
            dp[i]=-1;
        }
        for(int i=0; i<edges.length; i++){
            g[edges[i][0]].add(edges[i][1]);
        }
        return dfs(g, dp, src, dest);
    }
    int dfs(ArrayList<Integer>[] g, int dp[], int s, int d){
        if(s==d) return 1;
        if(dp[s]!=-1) return dp[s];
        int c=0;
        for(int i=0; i<g[s].size(); i++){
            c+=dfs(g, dp, g[s].get(i), d);
        }
        return dp[s]=c;
    }
}