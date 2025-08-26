class Solution {
    public boolean isSubSeq(String s1, String s2) {
        // code here
        int n=s1.length();
        int m=s2.length();
        int i=0, j=0;
        while(j<m && i<n){
            if(s1.charAt(i)==s2.charAt(j))
            i++;
            j++;
        }
        if(i==n) return true;
        return false;
    }
};