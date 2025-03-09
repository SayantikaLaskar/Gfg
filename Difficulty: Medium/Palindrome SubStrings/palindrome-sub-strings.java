//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();

            Solution obj = new Solution();

            System.out.println(obj.countPS(s));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {
    public int p(int s, int e, String t){
        int c=0; 
        int n=t.length();
        while(s>=0 && e<n && t.charAt(s)==t.charAt(e)){
            if(e-s+1>=2){
                c++;
            }
            s--;
            e++;
        }
        return c;
    }
    public int countPS(String s) {
        // code here
        int c=0;
        int n=s.length();
        for(int i=0; i<n; i++){
            c+=p(i, i, s);
            c+=p(i, i+1, s);
        }
        return c;
    }
}