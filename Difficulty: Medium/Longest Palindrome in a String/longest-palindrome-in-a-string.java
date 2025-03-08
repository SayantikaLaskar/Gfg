//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    static String longestPalindrome(String s) {
        // code here
        if(s==null || s.length()==0){
            return "";
        }
        int st=0, m=0;
        for(int i=0; i<s.length(); i++){
            int l1=e(s, i, i);
            int l2=e(s, i, i+1);
            int l=Math.max(l1, l2);
            if(l>m){
                m=l;
                st=i-(l-1)/2;
            }
        }
        return s.substring(st, st+m);
    }
    static int e(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}