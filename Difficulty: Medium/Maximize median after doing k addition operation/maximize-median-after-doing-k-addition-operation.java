class Solution {
    public int maximizeMedian(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        int m=(n-1)/2;
        long s=k;
        int sz=1, a=k+arr[m];
        if(n%2==0){
            a=(a+arr[m+1])/2;
            s+=arr[m++];
            sz++;
        }
        for(int i=m; i<n; i++){
            s+=arr[i];
            int h=(int)(s/sz++);
            a=Math.min(a, h);
        }
        return a;
    }
}
