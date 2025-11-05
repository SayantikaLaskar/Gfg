class Solution {
    public int minSquares(int n) {
        // Code here
         int[] dp = new int[n + 1];
        
        // Initializing dp values: maximum squares needed = n (1^2 + 1^2 + ... n times)
        for (int i = 1; i <= n; i++) {
            dp[i] = i; 
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int sq = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - sq]);
            }
        }

        return dp[n];
    }
}