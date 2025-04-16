//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] s = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) matrix[i][j] = Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.floydWarshall(matrix);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function template for JAVA

class Solution {
    public static void floydWarshall(int[][] dist) {
        int n = dist.length;

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Prevent integer overflow when checking for intermediate paths
                    if (dist[i][k] < 1e8 && dist[k][j] < 1e8) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    // Utility function to print the distance matrix
    public static void printMatrix(int[][] dist) {
        int n = dist.length;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (dist[i][j] >= 1e8)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int INF = 100000000; // 1e8

        int[][] dist1 = {
            {0, 4, INF, 5, INF},
            {INF, 0, 1, INF, 6},
            {2, INF, 0, 3, INF},
            {INF, INF, 1, 0, 2},
            {1, INF, INF, 4, 0}
        };

        int[][] dist2 = {
            {0, -1, 2},
            {1, 0, 108},
            {3, 1, 0}
        };

        System.out.println("Result for dist1:");
        floydWarshall(dist1);
        printMatrix(dist1);

        System.out.println("\nResult for dist2:");
        floydWarshall(dist2);
        printMatrix(dist2);
    }
}