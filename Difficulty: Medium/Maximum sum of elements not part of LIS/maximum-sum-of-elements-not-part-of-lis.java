class Solution {
    public int nonLisMaxSum(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int[] len = new int[n];
        int[] sum = new int[n];
        int maxLen = 1; // At least the element itself is a LIS of length 1

        for (int i = 0; i < n; i++) {
            len[i] = 1; // Each element is a LIS of length 1 by itself
            sum[i] = arr[i];
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    sum[i] = sum[j] + arr[i];
                } else if (arr[j] < arr[i] && len[j] + 1 == len[i]) {
                    // If same length, choose the smaller sum to minimize the LIS sum
                    if (sum[j] + arr[i] < sum[i]) {
                        sum[i] = sum[j] + arr[i];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        int minLisSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                minLisSum = Math.min(minLisSum, sum[i]);
            }
        }

        return totalSum - minLisSum;
    }
}