class Solution {
    public int vowelCount(String s) {
        // code here
        int[] f=new int[5];
        for(char ch: s.toCharArray()){
            if(ch=='a') f[0]++;
            else if(ch=='e') f[1]++;
            else if(ch=='i') f[2]++;
            else if(ch=='o') f[3]++;
            else if(ch=='u') f[4]++;
        }
        int c=0, w=1;
        for(int a:f){
            if(a>0){
                c++;
                w*=a;
            }
        }
        if(c==0) return 0;
        return w*fact(c);
    }
    static int fact(int n){
        int f=1;
        for(int i=2; i<=n; i++) f*=i;
        return f;
    }
}