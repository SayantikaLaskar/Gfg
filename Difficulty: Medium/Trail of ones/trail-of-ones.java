class Solution {
    public int countConsec(int n) {
        // code here
        if(n==2) return 1;
        int a=0, b=1, ans=1, mod=1000000007;
        for(int i=3; i<=n; i++){
            int c=(a+b);
            ans=((ans*2)+c);
            a=b;
            b=c;
        }
        return ans;
    }
}
