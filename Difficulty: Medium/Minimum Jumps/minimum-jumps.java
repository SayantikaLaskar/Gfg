class Solution {
    public int minJumps(int[] arr) {
        // code here
        int n=arr.length;
        if(n==1) return 0;
        if(arr[0]==0) return -1;
        int m=arr[0], s=arr[0], j=1;
        for(int i=1; i<n; i++){
            if(i==n-1) return j;
            m=Math.max(m, i+arr[i]);
            s--;
            if(s==0){
                j++;
                if(i>=m) return -1;
                s=m-i;
            }
        }
        return -1;
    }
}