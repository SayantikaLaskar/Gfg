class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int n=arr.length, s=0;
        for(int i=0; i<n; i++){
            s+=arr[i]*(i+1)*(n-i);
        }
        return s;
    }
}
