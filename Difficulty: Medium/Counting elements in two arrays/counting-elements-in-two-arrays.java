class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(b);
        for (int num : a) {
            int count = upperBound(b, num);
            result.add(count);
        }
        return result;
    }
    
    private static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}