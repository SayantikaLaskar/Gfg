class Solution {
    public int getCount(int n) {
        // code here
        if (n <= 0) return 0;

        // Build adjacency map for digits
        Map<Integer, int[]> adj = new HashMap<>();
        adj.put(0, new int[]{0, 8});
        adj.put(1, new int[]{1, 2, 4});
        adj.put(2, new int[]{2, 1, 3, 5});
        adj.put(3, new int[]{3, 2, 6});
        adj.put(4, new int[]{4, 1, 5, 7});
        adj.put(5, new int[]{5, 2, 4, 6, 8});
        adj.put(6, new int[]{6, 3, 5, 9});
        adj.put(7, new int[]{7, 4, 8});
        adj.put(8, new int[]{8, 5, 7, 9, 0});
        adj.put(9, new int[]{9, 6, 8});

        // Initialize DP for length 1
        long[] dp = new long[10];
        Arrays.fill(dp, 1);

        // DP iteration for lengths 2 to n
        for (int i = 2; i <= n; i++) {
            long[] newDp = new long[10];
            for (int digit = 0; digit <= 9; digit++) {
                if (adj.containsKey(digit)) {
                    for (int neighbor : adj.get(digit)) {
                        newDp[neighbor] += dp[digit];
                    }
                }
            }
            dp = newDp;
        }

        // Total all sequences of length n
        int total = 0;
        for (long count : dp) {
            total += count;
        }
        return total;
    }
}