//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public long getCount(int n) {
        // Your code goes here
        if (n == 1) return 10;

        int[][] adj = {
            {0, 8},     // 0
            {1, 2, 4},  // 1
            {2, 1, 3, 5}, // 2
            {3, 2, 6},  // 3
            {4, 1, 5, 7}, // 4
            {5, 2, 4, 6, 8}, // 5
            {6, 3, 5, 9}, // 6
            {7, 4, 8}, // 7
            {8, 5, 7, 9, 0}, // 8
            {9, 6, 8}  // 9
        };

        long[] dpPrev = new long[10];
        long[] dpCurr = new long[10];
        Arrays.fill(dpPrev, 1);
        
         for (int len = 2; len <= n; len++) {
            Arrays.fill(dpCurr, 0);
            for (int digit = 0; digit < 10; digit++) {
                for (int neighbor : adj[digit]) {
                    dpCurr[digit] += dpPrev[neighbor];
                }
            }
            System.arraycopy(dpCurr, 0, dpPrev, 0, 10);
        }

        long totalCount = 0;
        for (long count : dpPrev) {
            totalCount += count;
        }

        return totalCount;

    }
}