import java.util.Arrays;

class Solution {
    static boolean isPowerOfFive(String s, int st, int e) {
        long num = 0;
        long t = 1;
        for (int i = e; i >= st; i--) {
            if (s.charAt(i) == '1') {
                num += t;
            }
            t *= 2;
        }
        if (num == 0) return false; // leading zeros or "0" is not a power of 5
        while (num > 1) {
            if (num % 5 != 0) return false;
            num /= 5;
        }
        return true;
    }

    static int help(String s, int st, int e, int[][] dp) {
        if (st > e) return 0;
        if (s.charAt(st) == '0') return -1; // leading zero is invalid
        if (dp[st][e] != -1) return dp[st][e];
        if (isPowerOfFive(s, st, e)) {
            dp[st][e] = 1;
            return 1;
        }
        int minCuts = Integer.MAX_VALUE;
        for (int i = st; i < e; i++) {
            if (isPowerOfFive(s, st, i)) {
                int remainingCuts = help(s, i + 1, e, dp);
                if (remainingCuts != -1) {
                    minCuts = Math.min(minCuts, 1 + remainingCuts);
                }
            }
        }
        dp[st][e] = (minCuts == Integer.MAX_VALUE) ? -1 : minCuts;
        return dp[st][e];
    }

    public int cuts(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] temp : dp) {
            Arrays.fill(temp, -1);
        }
        return help(s, 0, n - 1, dp);
    }
}
