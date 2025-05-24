class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int a=0, n=s.length();
        for(int i=0; i<n; i++){
            a+=h(s, i, "");
        }
        return a;
    }
    public static int h(String s, int i, String sub){
        if(i==s.length()) return 0;
        sub=new StringBuilder(sub).append(s.charAt(i)).toString();
        return Integer.parseInt(sub)+h(s, i+1, sub);
    }
}