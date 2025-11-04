class Solution {
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n-1] = 0;
        
        for(int i=n-2;i>=0;i--) {
            dp[i] = Math.min(dp[i], Math.abs(height[i]-height[i+1])+dp[i+1]);
            if(i != n-2) {
                dp[i] = Math.min(dp[i], Math.abs(height[i]-height[i+2])+dp[i+2]);
            }
        }
        
        return dp[0];
    }
}