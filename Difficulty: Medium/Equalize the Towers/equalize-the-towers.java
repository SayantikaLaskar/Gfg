class Solution {
    public int minCost(int[] heights, int[] cost) {
        int n = heights.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = heights[i];
            arr[i][1] = cost[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long total = 0;
        for (int c : cost) total += c;
        long half = (total + 1) / 2, sum = 0;
        int median = 0;
        for (int[] a : arr) {
            sum += a[1];
            if (sum >= half) {
                median = a[0];
                break;
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.abs(heights[i] - median) * cost[i];
        }
        return res;
    }
}
