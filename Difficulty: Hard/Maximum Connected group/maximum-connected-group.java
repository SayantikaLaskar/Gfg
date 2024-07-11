//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int n;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[] parent;
    private int[] size;

    public int MaxConnection(int[][] grid) {
        n = grid.length;
        parent = new int[n * n];
        size = new int[n * n];
        
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        // Initial union of all 1's in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int[] direction : directions) {
                        int ni = i + direction[0];
                        int nj = j + direction[1];
                        if (isValid(ni, nj) && grid[ni][nj] == 1) {
                            union(i * n + j, ni * n + nj);
                        }
                    }
                }
            }
        }

        int maxGroupSize = 0;
        for (int i = 0; i < n * n; i++) {
            if (parent[i] == i && grid[i / n][i % n] == 1) {
                maxGroupSize = Math.max(maxGroupSize, size[i]);
            }
        }

        // Try changing each 0 to 1 and find the largest connected group
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueComponents = new HashSet<>();
                    int newSize = 1; // Size of the new component if we change this 0 to 1

                    for (int[] direction : directions) {
                        int ni = i + direction[0];
                        int nj = j + direction[1];
                        if (isValid(ni, nj) && grid[ni][nj] == 1) {
                            int root = find(ni * n + nj);
                            if (uniqueComponents.add(root)) {
                                newSize += size[root];
                            }
                        }
                    }

                    maxGroupSize = Math.max(maxGroupSize, newSize);
                }
            }
        }

        return maxGroupSize;
    }

    private boolean isValid(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
        }
    }
}
