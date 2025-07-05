class Solution {
    public int maxSum(int arr[]) {
        // code here
     int a=0;
     for(int i=1; i<arr.length; i++){
         a=Math.max(a, arr[i]+arr[i-1]);
     }
     return a;
    }
}